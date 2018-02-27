package com.briup.struts.chap4;

public class Check {
	/**
	  * �ж��ļ��Ƿ�ΪͼƬ<br>
	  * <br>
	  * @param pInput �ļ���<br>
	  * @param pImgeFlag �жϾ����ļ�����<br>
	  * @return ����Ľ�� true��ʾͼƬ false����ͼƬ<br>
	  * @throws Exception
	  */
	 public static boolean isPicture(String  pInput, 
	                           String pImgeFlag) throws Exception{
		  // �ļ�����Ϊ�յĳ���
			  if(pInput.equals("")){
			   // ���ز��ͺϷ�
			   return false;
			  }
			  // ����ļ���׺�� 
			  String tmpName = pInput.substring(pInput.lastIndexOf(".") + 1,
			                              pInput.length());
			  // ����ͼƬ��׺������
			  String imgeArray [][] = {
			    {"bmp", "0"}, {"dib", "1"}, {"gif", "2"},
			    {"jfif", "3"}, {"jpe", "4"}, {"jpeg", "5"},
			    {"jpg", "6"}, {"png", "7"} ,{"tif", "8"},
			    {"tiff", "9"}, {"ico", "10"}
			  };
			  // ������������
			  for(int i = 0; i<imgeArray.length;i++){
			   // �жϵ��������ļ��ĳ���
				  if(!pImgeFlag.equals("")&& imgeArray [i][0].equals(tmpName.toLowerCase()) && imgeArray [i][1].equals(pImgeFlag)){
					  return true;
				  }
				  // �жϷ���ȫ�����͵ĳ���
				  if(pImgeFlag.equals("")&& imgeArray [i][0].equals(tmpName.toLowerCase())){
					  return true;
				  }
			  }
			  return false;
	 	}	
}
