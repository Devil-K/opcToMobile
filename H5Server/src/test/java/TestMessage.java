import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/26 23:59
 * @ItemName: opcToMobile
 */
public class TestMessage {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void text1() {
        //第一种方法
        StringBuilder sb = new StringBuilder();//内容修饰
        sb.append("<html>");
        sb.append("<body>");
        sb.append("<h3>");
        sb.append("hello");
        sb.append("<a href='https://www.cnblogs.com/lin02/'>点击查看</a>");
        sb.append("</h3>");
        sb.append("</body>");
        sb.append("</html>");

//        创建媒体消息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("1771947201@qq.com");//发送人
            helper.setTo("\n" +
                    "59968873@qq.com");//接收人
            helper.setSubject("邮件标题");//标题
            helper.setText(sb.toString(), true);//发送的内容
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void text2() {
//      第一种
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("1771947201@qq.com");//发送者
        msg.setTo("\n" +
                "59968873@qq.com");//接收者
        msg.setSubject("邮箱标题");//标题
        msg.setText("https://www.cnblogs.com/lin02/");//内容
        javaMailSender.send(msg);
    }
}
