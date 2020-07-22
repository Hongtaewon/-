import React from "react";
import { View, Text, StyleSheet, StatusBar} from "react-native";
import PropTypes from "prop-types";
import { LinearGradient } from "expo-linear-gradient";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import MakeTable from "./MakeTable";

const weatherOptions = {
  Thunderstorm: {
    iconName: "weather-lightning",
    gradient: ["#373B44", "#4286f4"],
    subtitle: "천둥 번개가 치고 있으니 집에서 휴식하세요."
  },
  Drizzle: {
    iconName: "weather-hail",
    gradient: ["#89F7FE", "#66A6FF"],
    subtitle: "이슬비가 오니까 집에서 휴식하세요."
  },
  Rain: {
    iconName: "weather-rainy",
    gradient: ["#00C6FB", "#005BEA"],
    subtitle: "비가 오니까 집에서 휴식하세요."
  },
  Snow: {
    iconName: "weather-snowy",
    gradient: ["#7DE2FC", "#B9B6E5"],
    subtitle: "눈이 오니까 집에서 눈을 감상하세요."
  },
  Atmosphere: {
    iconName: "weather-hail",
    gradient: ["#89F7FE", "#66A6FF"]
  },
  Clear: {
    iconName: "weather-sunny",
    gradient: ["#FF7300", "#FEF253"],
    subtitle: "구름없이 맑으므로 집에서 태양을 피하세요."
  },
  Clouds: {
    iconName: "weather-cloudy",
    gradient: ["#D7D2CC", "#304352"],
    subtitle: "야외 활동하기 좋은 날"
  },
  Mist: {
    iconName: "weather-hail",
    gradient: ["#4DA0B0", "#D39D38"],
    subtitle: "안개는 위험할 수도 있으니 집에서 휴식하세요."
  },
  Dust: {
    iconName: "weather-hail",
    gradient: ["#4DA0B0", "#D39D38"],
    subtitle: "미세먼지는 몸에 안 좋으니 집에서 휴식하세요."
  },
  Haze: {
    iconName: "weather-hail",
    gradient: ["#4DA0B0", "#D39D38"],
    subtitle: "안개는 위험할 수도 있으니 집에서 휴식하세요."
  }
};


export default function Weather({data}) {

  const current = data.current;
  const hourly = data.hourly;
  const daily = data.daily;

  //console.log(current);
  //console.log(hourly);
  //console.log(daily);

  const temp = current.temp;
  const condition = current.weather[0].main;
  const description = current.weather[0].description;
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
      <View style={styles.CandleContainer}>
        <View style={styles.chartRow}>
          <여기에는 지금부터 앞으로의 온도 변화를 나타내는 표를 그림/>
        </View>
      </View>
      <View style={styles.ChartContainer}>
        <View style={styles.chartRow}>
        <MakeTable data={daily.slice(1,6)} />
        </View>
      </View>
      <View style={styles.textContainer}>
        <Text style={styles.title}>{description}</Text>
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
    justifyContent: "center",
    flex: 1,
    paddingTop: 30,
    width: '100%',
    height: '100%',
    alignItems: 'center',
  },
  CandleContainer: {
    alignItems: "flex-start",
    justifyContent: "center",
    flex: 1,
    paddingTop: 30,
    width: '100%',
    height: '100%',
    alignItems: 'center',
  },
  chartRow: {
    flex: 1,
    width: '100%'
  },
});