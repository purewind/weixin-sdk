package com.riversoft.weixin.app.care;

import com.riversoft.weixin.app.AppWxClientFactory;
import com.riversoft.weixin.app.base.AppSetting;
import com.riversoft.weixin.app.base.WxEndpoint;
import com.riversoft.weixin.app.message.Link;
import com.riversoft.weixin.app.message.MiniProgramPage;
import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.common.message.Media;
import com.riversoft.weixin.common.message.Text;
import com.riversoft.weixin.common.util.JsonMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 客服消息
 *
 * @borball on 12/29/2016.
 */
public class CareMessages {

    private WxClient wxClient;

    public static CareMessages defaultCareMessages() {
        return with(AppSetting.defaultSettings());
    }

    public static CareMessages with(AppSetting appSetting) {
        CareMessages messages = new CareMessages();
        messages.setWxClient(AppWxClientFactory.getInstance().with(appSetting));
        return messages;
    }

    public void setWxClient(WxClient wxClient) {
        this.wxClient = wxClient;
    }

    /**
     * 客服发送文本消息
     *
     * @param openId
     * @param text
     */
    public void text(String openId, String text) {
        Map<String, Object> request = initMessage(openId, "text");
        request.put("text", new Text(text));

        String url = WxEndpoint.get("url.care.message.send");
        wxClient.post(url, JsonMapper.defaultMapper().toJson(request));
    }


    /**
     * 客服发送图片消息
     *
     * @param openId
     * @param image
     */
    public void image(String openId, String image) {
        Map<String, Object> request = initMessage(openId, "image");
        request.put("image", new Media(image));

        String url = WxEndpoint.get("url.care.message.send");
        wxClient.post(url, JsonMapper.defaultMapper().toJson(request));
    }

    /**
     * 客服发送图文链接消息
     *
     * @param openId
     * @param title
     * @param link
     * @param description
     * @param thumbUrl
     */
    public void link(String openId, String title, String link, String description, String thumbUrl) {
        Map<String, Object> request = initMessage(openId, "link");
        Link message = new Link();
        message.url(link).title(title).description(description).thumbUrl(thumbUrl);
        request.put("link", message);

        String url = WxEndpoint.get("url.care.message.send");
        wxClient.post(url, JsonMapper.defaultMapper().toJson(request));
    }

    /**
     * 发送小程序信息
     *
     * @param openId
     * @param pagepath
     * @param title
     * @param image
     */
    public void miniProgramPage(String openId, String pagepath, String title, String image) {
        Map<String, Object> request = initMessage(openId, "miniprogrampage");
        MiniProgramPage message = new MiniProgramPage();
        message.pagePath(pagepath).title(title).thumbMediaId(image);
        request.put("miniprogrampage", message);

        String url = WxEndpoint.get("url.care.message.send");
        wxClient.post(url, JsonMapper.defaultMapper().toJson(request));
    }

    private Map<String, Object> initMessage(String openId, String msgType) {
        Map<String, Object> request = new HashMap<>();
        request.put("msgtype", msgType);
        request.put("touser", openId);

        return request;
    }
}
