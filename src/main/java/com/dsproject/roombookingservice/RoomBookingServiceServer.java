package com.dsproject.roombookingservice;

/*
 *		DISTRIBUTED SYSTEMS PROJECT - HDSDEV_SEP 
 *		@AUTHOR X20144148
 */	


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.dsproject.authenticationservices.AuthenticationServicesServer;
import com.dsproject.roombookingservice.RoomBookingServiceGrpc.RoomBookingServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.netty.util.internal.ThreadLocalRandom;
import io.grpc.stub.StreamObserver;

public class RoomBookingServiceServer extends RoomBookingServiceImplBase {
	
	private static final Logger logger = Logger.getLogger(RoomBookingServiceServer.class.getName());
	
	public static void main(String[] args) {
		//create server
		RoomBookingServiceServer roomBookingServiceServer = new RoomBookingServiceServer();
		
		Properties prop = roomBookingServiceServer.getProperties();
		roomBookingServiceServer.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port"));
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(roomBookingServiceServer)
					.build()
					.start();
			
		logger.info("Server has started. Listening on " + port);
		server.awaitTermination();
		}catch(IOException e) {
			System.out.println("Issue with server port. Check port and try again");
		}catch(InterruptedException e) {
			System.out.println("Server has encountered an error, please try again");
			
			
		}

	}
	//get jmdns properties
	private Properties getProperties() {
		Properties prop = null;
		try(InputStream input = new FileInputStream("src/main/resources/roombookingservice.properties")){
			prop = new Properties();
			
			prop.load(input);
			
			System.out.println("Room Booking Services properties : ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
	        
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return prop;
			
			
		}
	//register jmdns services
	private void registerService(Properties prop) {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			String service_type = prop.getProperty("service_type");
			String service_name = prop.getProperty("service_name");
			int service_port = Integer.valueOf(prop.getProperty("service_port"));
			
			String service_description_properties = prop.getProperty("service_description");
			
			ServiceInfo serviceInfo = ServiceInfo.create(service_type,  service_name,  service_port,  service_description_properties);
			jmdns.registerService(serviceInfo);
			
			System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
			System.out.println("Service has been registered! ");
			
			Thread.sleep(1000);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	//Check what rooms are available - Server streaming Grpc
	//Random used to generate random times, room names and how many will be sent back to the client
	
	@Override
	public void checkAvailableRooms(CheckAvailableRoomsRequest request, StreamObserver<CheckAvailableRoomsResponse> responseObserver) {
		System.out.println("Checking available rooms...");
		String date = request.getDate();
		String site = request.getLocation();
		
		String availableTimes;
		Random ran = new Random();
		int randomAvailableRooms = ran.nextInt((30 - 1) +1) + 1;
		try {
		for(int i=0; i<randomAvailableRooms; i++) {
				availableTimes = generateRandomTime();
				String roomName = generateRandomRoomName();
				
				CheckAvailableRoomsResponse response = CheckAvailableRoomsResponse.newBuilder()
						.setDate(date)
						.setRoomName(roomName)
						.setAvailableTimes(availableTimes)
						.build();

				responseObserver.onNext(response);
				Thread.sleep(1000L);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}catch (InterruptedException a) {
				a.printStackTrace();
			}finally {
				responseObserver.onCompleted();
		}
	}
	//Book a room - Unary grpc
	//Used Random to generate randomly whether a room is available or not. 
	@Override
	public void bookRoom(BookRoomRequest request, StreamObserver<BookRoomResponse> responseObserver) {
		String bookingConfirmation = generateRandomAvailability();
		String available = "Available";
		String notAvailable = "Not Available";
		String date = request.getDate();
		String time = request.getTime();
		int numAttendees = request.getNumAttendees();
		String catering = request.getCateringRequired();
		String roomName = generateRandomRoomName();
		
		
		if(bookingConfirmation.equalsIgnoreCase("Yes")) {
			responseObserver.onNext(BookRoomResponse.newBuilder()
					.setBookingConfirmation("A room is " + available + " and has been booked. Details are listed below : ")
					.setRoomName("\n Room Name : " + roomName)
					.setDate("\n Date : " + date)
					.setTime("\n Time : " + time + "\n Number of Attendees : " )
					.setNumAttendees(numAttendees)
					.setCateringRequirements("\n Catering Required : " + catering)
					.build());
					
		}else if(bookingConfirmation.equalsIgnoreCase("No")) {
			responseObserver.onNext(BookRoomResponse.newBuilder()
					.setBookingConfirmation("Unfortunately a room is " + notAvailable 
							+ " for your specified date. Please choose an alternative date and try again.")
					.build());
		}
		responseObserver.onCompleted();
	}
	
	//METHOD TO GENERATE RANDOM AVAILABILITY
	public static String generateRandomAvailability() {
		String[] avail = {"Yes" , "No"};
		String ranAvail;
		ranAvail = avail[(int)(Math.random()*avail.length)];
		return ranAvail;
	}
	
	//METHOD TO GENERATE RANDOM DATE = NOT NEEDED NOW.
	public static String generateRandomDate() {
		LocalDate startDate = LocalDate.now();
		long start = startDate.toEpochDay();
		
		LocalDate endDate = LocalDate.of(2022, 04, 30);
		long end = endDate.toEpochDay();
		
		long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
		LocalDate ranDate = LocalDate.ofEpochDay(randomDate);
		
		ranDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String formatRandomDate = ranDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
		
		return formatRandomDate;
	}
	
	//METHOD TO GENRATE A RANDOM ROOM NAME
	public static String generateRandomRoomName() {
		 String[] roomNames = {"Green Room", "Red Room" , "Apple Room" ,"Purple Room" ,"Yellow Room", "Orange Room" ,"Blue Room" ,"Plum Room"};
		 String randomRoomName;
		 randomRoomName = roomNames[(int) (Math.random()*roomNames.length)];
		 return randomRoomName;
		
	}
	
	//METHOD TO GENERATE A RANDOM BLOCK OF 30 MINUTE TIMES 
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
}













