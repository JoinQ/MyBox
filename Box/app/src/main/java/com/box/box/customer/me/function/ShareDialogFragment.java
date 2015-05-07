package com.box.box.customer.me.function;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.box.box.R;
import com.box.mode.ShareDialog;
import com.box.util.Utils;
import com.box.widget.MyRecyclerAdapter;
import com.box.widget.ShareDialogRecyclerAdapter;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.SmsHandler;
import com.umeng.socialize.sso.TencentWBSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

import java.util.HashMap;
import java.util.Map;

public class ShareDialogFragment extends DialogFragment implements MyRecyclerAdapter.OnRecyclerItemClickListener {
    private RecyclerView recyclerView;
    private ShareDialogRecyclerAdapter adapter;

    private final UMSocialService mController = UMServiceFactory.getUMSocialService("myshare");
    private Map<String, SHARE_MEDIA> mPlatformsMap = new HashMap<String, SHARE_MEDIA>();

    private static final int FC_ID = 0;
    private static final int WEICHANT_ID = 1;
    private static final int QQ_ID = 2;
    private static final int QZONE_ID = 3;
    private static final int TECENT_ID = 4;
    private static final int SINA_ID = 5;
    private static final int RENREN_ID = 6;
    private static final int MESSAGE_ID = 7;

    private static final ShareDialog arry[] = {new ShareDialog(R.drawable.umeng_socialize_wxcircle, "朋友圈"),
            new ShareDialog(R.drawable.umeng_socialize_wechat, "分享到微信"),
            new ShareDialog(R.drawable.umeng_socialize_qq_on, "分享到QQ"),
            new ShareDialog(R.drawable.umeng_socialize_qzone_on, "分享到QQ空间"),
            new ShareDialog(R.drawable.umeng_socialize_tx_on, "分享到腾讯微博"),
            new ShareDialog(R.drawable.umeng_socialize_sina_on, "分享到新浪微博"),
            new ShareDialog(R.drawable.umeng_socialize_renren_on, "分享到人人"),
            new ShareDialog(R.drawable.umeng_socialize_sms_on, "分享到短信")};

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, (int) (Utils.getScreenHeight() * 2.0 / 3.0));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
        adapter = new ShareDialogRecyclerAdapter(arry, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dialog_share, container, false);
        initView(root);
        initSocialSDK();
        initPlatformMap();
        initContent();
        return root;
    }

    private void initView(View root) {
        recyclerView = (RecyclerView) root.findViewById(R.id.share_dialog_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerOnClickListener(this);
    }

    private void initSocialSDK() {
        // 添加QQ平台
        UMQQSsoHandler qqHandler = new UMQQSsoHandler(getActivity(), "1104543599", "aBUy3uJy2d5x3boc");
        // 添加QQ空间平台
        QZoneSsoHandler qzoneHandler = new QZoneSsoHandler(getActivity(), "1104543599", "aBUy3uJy2d5x3boc");
        //添加微信平台
        UMWXHandler wxHandler = new UMWXHandler(getActivity(), "wx432d1ffff8798554", "b570369d3e528fe6954991a7746813af");
        UMWXHandler wxCircleHandler = new UMWXHandler(getActivity(), "wx432d1ffff8798554", "b570369d3e528fe6954991a7746813af");
        wxCircleHandler.setToCircle(true);
        //添加sina微博平台
        mController.getConfig().setSsoHandler(new SinaSsoHandler());
        //添加腾讯微博平台
        mController.getConfig().setSsoHandler(new TencentWBSsoHandler());
        //添加人人平台
        //添加短信平台
        SmsHandler smsHandler = new SmsHandler();
        qqHandler.addToSocialSDK();
        qzoneHandler.addToSocialSDK();
        wxHandler.addToSocialSDK();
        wxCircleHandler.addToSocialSDK();
        smsHandler.addToSocialSDK();
    }

    private void initContent() {
        QQShareContent qq = new QQShareContent();
        qq.setShareContent("分享");
        qq.setTitle("Box分享");
        qq.setShareImage(new UMImage(getActivity(), R.mipmap.ic_launcher));
        qq.setTargetUrl("http://www.baidu.com");

        WeiXinShareContent wx =new WeiXinShareContent();
        wx.setShareContent("分享");
        wx.setTitle("Box分享");
        wx.setShareImage(new UMImage(getActivity(), R.mipmap.ic_launcher));
        wx.setTargetUrl("http://www.baidu.com");
        mController.setShareMedia(qq);
        mController.setShareMedia(wx);
    }


    private void initPlatformMap() {
        mPlatformsMap.put(FC_ID + "", SHARE_MEDIA.WEIXIN_CIRCLE);
        mPlatformsMap.put(WEICHANT_ID + "", SHARE_MEDIA.WEIXIN);
        mPlatformsMap.put(QQ_ID + "", SHARE_MEDIA.QQ);
        mPlatformsMap.put(QZONE_ID + "", SHARE_MEDIA.QZONE);
        mPlatformsMap.put(TECENT_ID + "", SHARE_MEDIA.TENCENT);
        mPlatformsMap.put(SINA_ID + "", SHARE_MEDIA.SINA);
        mPlatformsMap.put(RENREN_ID + "", SHARE_MEDIA.RENREN);
        mPlatformsMap.put(MESSAGE_ID + "", SHARE_MEDIA.SMS);
    }

    @Override
    public void onItemClick(View v, int position) {
        // 设置文字分享内容
        mController.setShareContent("Box分享");
        // 图片分享内容
        mController.setShareMedia(new UMImage(getActivity(), R.mipmap.ic_launcher));
        mController.postShare(getActivity(), mPlatformsMap.get(position + ""), new SocializeListeners.SnsPostListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, SocializeEntity socializeEntity) {
                if ( i == 200) {
                } else {
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(requestCode) ;
        if(ssoHandler != null){
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }
}
