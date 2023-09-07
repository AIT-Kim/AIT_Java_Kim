//-------------------------------------------------
//	 Copyright (C) 2023
//	 Email:    evgeniikim@gmail.com
//   Author:   Yevhen Kim
//-------------------------------------------------
package lesson_03;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;



public class TimelineApiForecast {
    
    public static List<Double> timelineRequestHttpClient(String Location, LocalDate StartDate, LocalDate EndDate) throws Exception {
        List<Double> temps = new ArrayList<Double>();
        if (Location==null || Location.isEmpty() || StartDate == null || EndDate == null)
            return temps;

        //set up the end point
        String apiEndPoint="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
        String location = Location; //"Wolfhagen,DE";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = StartDate.format(formatter); //"2023-08-28";
        String endDate = EndDate.format(formatter); //"2023-09-03";

        String unitGroup="metric";
        String apiKey="LNNP2U5LBFGHA3LJH7WMMQPFC";

        StringBuilder requestBuilder=new StringBuilder(apiEndPoint);
        requestBuilder.append(URLEncoder.encode(location, StandardCharsets.UTF_8.toString()));

        if (startDate!=null && !startDate.isEmpty()) {
            requestBuilder.append("/").append(startDate);
            if (endDate!=null && !endDate.isEmpty()) {
                requestBuilder.append("/").append(endDate);
            }
        }

        URIBuilder builder = new URIBuilder(requestBuilder.toString());

        builder.setParameter("unitGroup", unitGroup)
                .setParameter("key", apiKey);



        HttpGet get = new HttpGet(builder.build());

        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = httpclient.execute(get);

        String rawResult=null;
        try {
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.printf("Bad response status code:%d%n", response.getStatusLine().getStatusCode());
                System.out.println("200 - OK – request was successful.");
                System.out.println("400 – BAD_REQUEST – if you requests is invalid in some way (invalid dates, bad location parameter etc).");
                System.out.println("401 – UNAUTHORIZED – when the API key is incorrect or your account status is inactive or disabled. In this case, check your API key or check the status of your account on the account page of the web site.");
                System.out.println("429 – TOO_MANY_REQUESTS – if you submit queries the exceed your plan concurrency limits or daily or monthly cost limits. If you exceed your concurrency limit you can resubmit your request. However please note that excessive use of 429 catch and retry logic to circumvent concurrency limits is prohibited. See What is the cause of “Maximum concurrent jobs has been exceeded”, HTTP response 429 for more information.");
                System.out.println("500 – INTERNAL_SERVER_ERROR – if our servers encounter an unexpected error. These are rare and our internal operations team will be notified. For more information, please log a tech support ticket including full details of the request and error response.");
                return temps;
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                rawResult=EntityUtils.toString(entity, Charset.forName("utf-8"));
            }


        } finally {
            response.close();
        }

        return parseTimelineJson(rawResult);

    }
    private static List<Double> parseTimelineJson(String rawResult) {
        List<Double> temps = new ArrayList<Double>();

        if (rawResult==null || rawResult.isEmpty()) {
            System.out.printf("No raw data%n");
            return temps;
        }

        JSONObject timelineResponse = new JSONObject(rawResult);

        ZoneId zoneId=ZoneId.of(timelineResponse.getString("timezone"));

        System.out.printf("Weather data for: %s%n", timelineResponse.getString("resolvedAddress"));

        JSONArray values=timelineResponse.getJSONArray("days");

        System.out.printf("Date\tTemp\tMaxTemp\tMinTemp\tPrecip\tSource%n");
        for (int i = 0; i < values.length(); i++) {
            JSONObject dayValue = values.getJSONObject(i);

            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);


            double temp=dayValue.getDouble("temp");
            temps.add(temp);
            double maxtemp=dayValue.getDouble("tempmax");
            double mintemp=dayValue.getDouble("tempmin");
            double pop=dayValue.getDouble("precip");
            String source=dayValue.getString("source");
            System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%.1f\t%s%n", datetime.format(DateTimeFormatter.ISO_LOCAL_DATE), temp, maxtemp, mintemp, pop,source );
        }
        return temps;
    }


    public static List<Double> GetForecast(String location, LocalDate StartDate, LocalDate EndDate)  throws Exception {
        return TimelineApiForecast.timelineRequestHttpClient(location, StartDate, EndDate);
    }
}