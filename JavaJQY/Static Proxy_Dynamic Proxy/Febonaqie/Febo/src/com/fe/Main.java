package com.fe;

import java.lang.reflect.Proxy;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciReal realF=new FibonacciReal();
		FibonacciProxy proxyF=new FibonacciProxy(realF);
		GetFib ff=(GetFib)Proxy.newProxyInstance(realF.getClass().getClassLoader(),realF.getClass().getInterfaces(), proxyF);
		System.out.println("쳲���������:1��1��2��3��5��8��13��21��34������\n����ڼ��");
		Scanner reader=new Scanner(System.in);
		int fNum=reader.nextInt();
		//ff.getFib(4);
		System.out.println("��1��ʼ쳲��������е�"+fNum+"���ǣ�  "+ff.getFib(fNum));
	}

}