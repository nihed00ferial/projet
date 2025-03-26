/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package weatherclient2;

import com.weather.WeatherWS;
import com.weather.WeatherWSService; // ✅ التأكد من استخدام الاسم الصحيح للخدمة

public class Main {
    public static void main(String[] args) {
        try {
            // ✅ إنشاء كائن للوصول إلى الخدمة بالطريقة الصحيحة
            WeatherWSService service = new WeatherWSService();
            WeatherWS port = service.getWeatherWSPort();

            // ✅ تحديد المدينة المطلوبة (تأكد من أنها ليست null أو فارغة)
            String city = "TIARET"; // يمكنك تغييره إلى أي مدينة أخرى

            // ✅ استدعاء خدمة الطقس
            String weatherData = port.getWeather(city);

            // ✅ عرض بيانات الطقس
            System.out.println("Weather Data for " + city + ":");
            System.out.println(weatherData);

        } catch (Exception ex) {
            System.out.println("❌ Error: " + ex.getMessage());
        }
    }
}
     