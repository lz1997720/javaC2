package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 这个类用来模拟乘客进站排队买票。
 * 
 * line1到line4表示4个窗口，乘客排队，然后买票离开。
 * 
 * 完成下面的方法：
 * 
 * comingPassagers， 用来生成进站的乘客。
 * lineUp， 用来将生成的乘客排入到售票窗口
 * saleTickets， 用来模拟售出车票
 * 
 * passagersInLines， 用来统计最后还有多少乘客没有买到车票
 * 
 * 
 */
public class LineInStation {
	private static int totalPassagers = 0;

	private static List<String> names = Arrays.asList("Jim", "Ken", "Leon", "Ada", "Lily", "Lucy", "Will", "Eagle",
			"David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean");
	
	private static int saledTikets = 0;

	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			saleTickets();

			List<Person> passages = comingPassagers();
			lineUp(passages);

			passages = comingPassagers();
			lineUp(passages);

			System.out.println(linesDesc());
		}

		int passagers = passagersInLines();

		System.out.printf("总共有%d个乘客进入车站，卖出%d张车票，还有%d个乘客没有买到车票。\n", totalPassagers, saledTikets, passagers);
	}

	/*
	 * 此方法应该随机生成一个长度为1~3的list，表示1~3个乘客来到车站，
	 * 
	 * 并统计总的进站人数到(totalPassagers)
	 * 
	 * 名字随机从names中获取,也可以自己想办法生成
	 * 
	 */
	public static List<Person> comingPassagers() {
		int num = (int)(Math.random()*3);
        int lnum = (int)(Math.random()*names.size());
		List<Person> passagers = new ArrayList<Person>(num);
		
		for (int i = 0; i < num; i++) {
			Person person = new Person(names.get(lnum));
			passagers.add(person);
		}
		return passagers;
	}


	
	/*
	 * 此方法将乘客排进队伍中，一同到来的乘客为了买票买到一起，他们会排到 同一个队伍。
	 * 
	 * 乘客会挑选最短的队伍进行排队
	 */
	public static void lineUp(List<Person> passages) {
          List<Person> min = line1;
          if(min.size() > line2.size()){
        	  min = line2;
          }
          
          if(min.size() > line3.size()){
        	  min = line3;
          }
          
          if(min.size() > line4.size()){
        	  min = line4;
          }
          
         min.addAll(passages);
	}

	/*
	 * 这个方法给每个队伍卖出一张车票，并统计总共卖出的票数到（saledTikets）。
	 * 
	 * 拿到票的乘客会离开车站
	 * 
	 * 就是排队伍第一个位置的乘客从队列中删除
	 */
	static int inLineNum1;
	static int inLineNum2;
	static int inLineNum3;
	static int inLineNum4;
	public static void saleTickets() {
		if(line1.isEmpty()){
			inLineNum1= line1.size();
			line1.remove(0);
			saledTikets++;
		}
        if(line2.isEmpty()){
        	inLineNum2= line2.size();
    		line2.remove(0);
    		saledTikets++;
        }
		if(line3.isEmpty()){
			inLineNum3= line3.size();
			line3.remove(0);
    		saledTikets++;
		}
		if(line4.isEmpty()){
			line4.remove(0);
			saledTikets++;
			inLineNum4= line4.size();
		}

	}

	/*
	 * 统计还有多少个乘客没有买到车票
	 */
	public static int passagersInLines() {
		return totalPassagers-(inLineNum1 + inLineNum2 + inLineNum3 +inLineNum4);
	}



	public static String linesDesc() {
		
		
		
		return "line1:" + line1.toString() + "\n" 
	         + "line2:" + line2.toString() + "\n" 
			 + "line3:" + line3.toString() + "\n" 
	         + "line4:" + line4.toString() + "\n";
	}
}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return name;
	}
}