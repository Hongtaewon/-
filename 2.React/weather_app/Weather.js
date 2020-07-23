import React from "react";
import { View, Text, StyleSheet, StatusBar, ScrollView} from "react-native";
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

const daylist = ["월","화","수","목","금","토","일"];

export default function Weather({data}) {

  const current = data.current;
  const hourly = data.hourly;
  const daily = data.daily;

  console.log(hourly);

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

        <View style={styles.currentDate}>
          <View style={{flex: 1, flexDirection: 'row'}} >
            <View style={styles.currentTime}>
              <Text style={styles.date}>{new Date(current.dt*1000).getMonth()+1}월</Text>
              <Text style={styles.date}>{new Date(current.dt*1000).getDate()}일</Text>
              <Text style={styles.day}>{daylist[new Date(current.dt*1000).getDay()-1]}요일</Text>
            </View>
          </View>
        </View>

        <View style={styles.currentTemp}>
          <MaterialCommunityIcons
            size={70}
            name={weatherOptions[condition].iconName}
            color="white"
          />
          <Text style={styles.temp}>{temp}°</Text>
        </View>

        <View style={styles.currentInfo}>
          <Text style={styles.info}>체감온도: {current.feels_like}°</Text>
          <Text style={styles.info}>습도: {current.humidity}%</Text>
          <Text style={styles.info}>가시거리: {current.visibility}m</Text>
          <Text style={styles.info}>풍속: {current.wind_speed}m/s</Text>
        </View>
      </View>
      <View style={styles.TableContainer}>
        <View style={styles.chartRow}>
        </View>
      </View>
      <View style={styles.CandleContainer}>
        <ScrollView style={styles.chartRow} horizontal={true}>
        <MakeTable data={daily.slice(1,8)} />
        </ScrollView>
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
    fontSize: 20,
    color: "white"
  },
  halfContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    margin: (10, 0, 0, 0),
    flexDirection: 'row',
    borderWidth: 0.5,
    borderColor: "#f2f2f2",
  },
  currentTime:{
    justifyContent: "center",
    alignItems: "center",
  },
  currentDate:{
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  currentTemp:{
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  currentInfo:{
    flex: 1,
    justifyContent: "center",
    alignItems: "flex-start",
  },
  title: {
    color: "white",
    fontSize: 30,
    fontWeight: "300",
    textAlign: "left"
  },
  subtitle: {
    fontWeight: "600",
    color: "white",
    fontSize: 16,
    textAlign: "left"
  },
  textContainer: {
    alignItems: "flex-start",
    paddingHorizontal: 40,
    justifyContent: "center",
    flex: 1
  },
  TableContainer: {
    alignItems: "flex-start",
    justifyContent: "center",
    flex: 1,
    width: '100%',
    height: '100%',
    alignItems: 'center',
    borderWidth: 0.5,
    borderColor: "#f2f2f2",
  },
  CandleContainer: {
    alignItems: "flex-start",
    justifyContent: "center",
    flex: 1,
    width: '100%',
    height: '100%',
    alignItems: 'center',
    borderWidth: 0.5,
    borderColor: "#f2f2f2",
  },
  chartRow: {
    flex: 1,
    width: '100%'
  },
  date: {
    fontSize: 25,
    color: "white"
  },
  day: {
    fontSize: 20,
    color: "white"
  },
  info: {
    fontSize: 12,
    color: "white"
  }
});