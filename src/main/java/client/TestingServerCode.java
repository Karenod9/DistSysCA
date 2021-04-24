package client;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import io.grpc.netty.shaded.io.netty.util.internal.ThreadLocalRandom;

public class TestingServerCode {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

//		
//		
//		LocalDate startDate = LocalDate.now();
//		long start = startDate.toEpochDay();
//		System.out.println(start);
//		LocalDate endDate = LocalDate.of(2022, 04, 30);
//		long end = endDate.toEpochDay();
//		System.out.println(end);
//		
//		long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
//		System.out.println(LocalDate.ofEpochDay(randomDate));
		
		
		//String from = generateRandomTime();
		
		System.out.println(generateRandomTime());
		
//		String startTime = generateRandomTime();
//		String endTime = generateRandomTime();
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(startTime);
//		sb.append(" - ");
//		sb.append(endTime);
//		String randomTimeBlock = sb.toString();
//		System.out.println(randomTimeBlock);
//		
//		
//		LocalTime sTime = new LocalTime(int 09);
//		
//		LocalTime lt = 09?00?00;
//		
//		System.out.println(between(09:00:00, ));
	}
	
	public static String generateRandomDate() {
		LocalDate startDate = LocalDate.now();
		long start = startDate.toEpochDay();
		System.out.println(start);
		
		LocalDate endDate = LocalDate.of(2022, 04, 30);
		long end = endDate.toEpochDay();
		System.out.println(end);
		
		long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
		LocalDate ranDate = LocalDate.ofEpochDay(randomDate);
		
		ranDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		//String newRanDate = ranDate.toString();
		System.out.println(ranDate);
		//System.out.println(newRanDate);
		//ranDate.toString();

		String formatRandomDate = ranDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
		
		return formatRandomDate;
	}
	
	
	public static Double generateRandomDouble() {
		Random ran = new Random();
		double ranRoomNumber = ran.nextInt(100) / 10.00;
		
		return ranRoomNumber;
	}
	
	public static String generateRandomRoomName() {
		 String[] roomNames = {"Green Room", "Red Room" , "Apple Room" ,"Purple Room" ,"Yellow Room", "Orange Room" ,"Blue Room" ,"Plum Room"};
		 String room;
		 room = roomNames[(int) (Math.random()*roomNames.length)];
		 return room;
		
	}
	
	
	public static String generateRandomTime() throws ParseException {
		Random random = new Random();
		int time = 24*60*60*10;
		Time startTime = new Time((long)random.nextInt(time));
		
		String startTimes = startTime.toString();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date startDateTime = df.parse(startTimes);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDateTime);
		cal.add(Calendar.MINUTE, 30);
		String endTime = df.format(cal.getTime());
		
		String startingTime = df.format(startDateTime);
		
		StringBuffer sb = new StringBuffer();
		sb.append(startingTime);
		sb.append(" - ");
		sb.append(endTime);
		String randomTime = sb.toString();
		
		return randomTime;
	}
	
	
	
	public LocalTime between(LocalTime startTime, LocalTime endTime) {
		
		int startSec = startTime.toSecondOfDay();
		int endSec = endTime.toSecondOfDay();
		int randomTime = ThreadLocalRandom.current().nextInt(startSec, endSec);
		return LocalTime.ofSecondOfDay(randomTime);
	}
	
	


}
