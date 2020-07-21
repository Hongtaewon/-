import React from "react";
import { View, Text, StyleSheet, StatusBar, Dimensions } from "react-native";
import PropTypes from "prop-types";
import { LinearGradient } from "expo-linear-gradient";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import { LineChart } from "react-native-chart-kit";

const weatherOptions = {
  Thunderstorm: {
    iconName: "weather-lightning",
    gradient: ["#373B44", "#4286f4"],
    title: "람쥐썬더",
    subtitle: "천둥 번개가 치고 있으니 집에서 휴식하세요."
  },
  Drizzle: {
    iconName: "weather-hail",
    gradient: ["#89F7FE", "#66A6FF"],
    title: "이슬비",
    subtitle: "이슬비가 오니까 집에서 휴식하세요."
  },
  Rain: {
    iconName: "weather-rainy",
    gradient: ["#00C6FB", "#005BEA"],
    title: " Rain unlike sun",
    subtitle: "비가 오니까 집에서 휴식하세요."
  },
  Snow: {
    iconName: "weather-snowy",
    gradient: ["#7DE2FC", "#B9B6E5"],
    title: "눈이 온다!!",
    subtitle: "눈이 오니까 집에서 눈을 감상하세요."
  },
  Atmosphere: {
    iconName: "weather-hail",
    gradient: ["#89F7FE", "#66A6FF"]
  },
  Clear: {
    iconName: "weather-sunny",
    gradient: ["#FF7300", "#FEF253"],
    title: "너무 맑음",
    subtitle: "구름없이 맑으므로 집에서 태양을 피하세요."
  },
  Clouds: {
    iconName: "weather-cloudy",
    gradient: ["#D7D2CC", "#304352"],
    title: "미래가 흐림",
    subtitle: "야외 활동하기 좋은 날"
  },
  Mist: {
    iconName: "weather-hail",
    gradient: ["#4DA0B0", "#D39D38"],
    title: "안개!!",
    subtitle: "안개는 위험할 수도 있으니 집에서 휴식하세요."
  },
  Dust: {
    iconName: "weather-hail",
    gradient: ["#4DA0B0", "#D39D38"],
    title: "으으 미세먼지",
    subtitle: "미세먼지는 몸에 안 좋으니 집에서 휴식하세요."
  },
  Haze: {
    iconName: "weather-hail",
    gradient: ["#4DA0B0", "#D39D38"],
    title: "안개!!",
    subtitle: "안개는 위험할 수도 있으니 집에서 휴식하세요."
  }
};


function MakeChart({data}){


  
  const timelist = data.list.map((x) => [x.dt_txt]);
  const templist = data.list.map((x) => [x.main.temp]);

  return (
    <LineChart 
          data={{
            labels: timelist,
            datasets: [
              {
                data: templist
              }
            ]
          }}
          width={screen.width} // from react-native
          height={screen.height/3}
          yAxisLabel=""
          yAxisSuffix="°"
          yAxisInterval={2} // optional, defaults to 1
          chartConfig={{
            backgroundGradientFromOpacity: 0,
            backgroundGradientToOpacity: 0,
            decimalPlaces: 2, // optional, defaults to 2dp
            color: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
            labelColor: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
           
          }}
          style={{
            marginLeft: 0,
            borderRadius: 16
          }}
      
        

        />
  );
}

export default function Weather({data}) {

  console.log(data);

  const temp = data.list[0].main.temp;
  const condition = data.list[0].weather[0].main;

  return (
    <LinearGradient
      colors={weatherOptions[condition].gradient}
      style={styles.container}
    >
      <StatusBar barStyle="light-content" />
      <View style={styles.halfContainer}>
        <MaterialCommunityIcons
          size={96}
          name={weatherOptions[condition].iconName}
          color="white"
        />
        <Text style={styles.temp}>{temp}°</Text>
      </View>
      <View style={styles.ChartContainer}>
        <MakeChart data={data} />
      </View>
      <View style={styles.textContainer}>
        <Text style={styles.title}>{weatherOptions[condition].title}</Text>
        <Text style={styles.subtitle}>
          {weatherOptions[condition].subtitle}
        </Text>
      </View>
    </LinearGradient>
  );

}

Weather.propTypes = {
};

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  temp: {
    fontSize: 42,
    color: "white"
  },
  halfContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center"
  },
  title: {
    color: "white",
    fontSize: 44,
    fontWeight: "300",
    marginBottom: 10,
    textAlign: "left"
  },
  subtitle: {
    fontWeight: "600",
    color: "white",
    fontSize: 24,
    textAlign: "left"
  },
  textContainer: {
    alignItems: "flex-start",
    paddingHorizontal: 40,
    justifyContent: "center",
    flex: 1
  },
  ChartContainer: {
    alignItems: "flex-start",
    paddingHorizontal: 40,
    justifyContent: "center",
    flex: 1
  }
});