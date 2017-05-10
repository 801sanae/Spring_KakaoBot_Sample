package syu.chatbot.biz;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController
{
	@RequestMapping(value = "/keyboard", method = RequestMethod.GET)
	public KeyboardVO keyboard()
	{
		KeyboardVO keyboard=new KeyboardVO(new String[] {"����", "��", "���ڸ޼���"});
	
		return keyboard;
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public ResponseMessageVO message(@RequestBody RequestMessageVO vo)
	{
		ResponseMessageVO res_vo=new ResponseMessageVO();
		MessageVO mes_vo=new MessageVO();
		
		if(vo.getContent().equals("����ȭ��"))
		{
			mes_vo.setText("ù ȭ���� ȣ���մϴ�.");
			
			KeyboardVO keyboard=new KeyboardVO(new String[] {"����", "��", "���ڸ޼���"});
			
			res_vo.setKeyboard(keyboard);
		}
		else if(vo.getContent().equals("����"))
		{
			PhotoVO photo=new PhotoVO();
			
			photo.setUrl("http://placehold.it/640x480.jpg");
			photo.setWidth(640);
			photo.setHeight(480);
			
			mes_vo.setPhoto(photo);
			mes_vo.setText(vo.getContent());
		}
		else if(vo.getContent().equals("��"))
		{
			MessageButtonVO messageButton=new MessageButtonVO();
			
			messageButton.setLabel("GITHUB");
			messageButton.setUrl("https://github.com/sjh836/Spring_KakaoBot_Sample");
			
			mes_vo.setMessage_button(messageButton);
			mes_vo.setText("���� �ǵ���Ź�帳�ϴ�! STAR�� �����ڸ� ���߰� ������!");
		}
		else //���ڸ޽���
		{
			mes_vo.setText(vo.getContent());
		}
		
		res_vo.setMessage(mes_vo);
		return res_vo;
	}
}
