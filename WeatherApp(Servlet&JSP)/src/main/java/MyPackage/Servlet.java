package MyPackage;
import java.util.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cityName=request.getParameter("userInput");
		
		
		//-----------------API Setup
		String apiKey="b96541239912666a06113811494c18e8";
		String apiUrl="https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+apiKey;
		
		//--_API Integraation
		URL url=new URL(apiUrl);
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET"); //get bcz we want to fetch data or req is sent
		
		
		///Reading data from network
		InputStream inputStream=conn.getInputStream(); //input receiving 
		InputStreamReader reader=new InputStreamReader(inputStream); //reading received input
		
		
		//storing the input
		StringBuilder apiResponse=new StringBuilder();
		
		Scanner sc=new Scanner(reader); //for taking input from reader
		while(sc.hasNext()) {
			//loop will be running while we have the next line
			apiResponse.append(sc.nextLine());
		}
		sc.close();
		
		
		//Converting string to json format
		//Gson library allows to convert json data to tree model.
		Gson gson=new Gson();
		try { 
		    JsonObject jsonObject = gson.fromJson(apiResponse.toString(), JsonObject.class);
		    
		    
		    //Date & time
		    long dateTime=jsonObject.get("dt").getAsLong()*1000;
		    String date=new Date(dateTime).toString();
		    
		    
		    int temprature=(int) (jsonObject.getAsJsonObject("main").get("temp").getAsDouble()-273.15);
		    int temp_min=(int) (jsonObject.getAsJsonObject("main").get("temp_max").getAsDouble()-273.15);
		    int temp_max=(int) (jsonObject.getAsJsonObject("main").get("temp_min").getAsDouble()-273.15);
		    
		    double windSpeed=jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
		    
		    int humidity=jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
		    
		    String WeatherCon=jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
		     
		    request.setAttribute("Date", date);
		    request.setAttribute("City", cityName);
		    request.setAttribute("Temprature", temprature);
		    request.setAttribute("MinimumTemprature", temp_min);
		    request.setAttribute("MaximumTemprature",temp_max);
		    request.setAttribute("Wind",windSpeed);
		    request.setAttribute("Humidity", humidity);
		    request.setAttribute("WeatherCondition", WeatherCon);
		    
		    conn.disconnect();
		}
		
		catch (Exception e) {
		    e.printStackTrace();
		}
		// forward the req to index.jsp for rendering
		request.getRequestDispatcher("index.jsp").forward(request, response);
		

	}

}
