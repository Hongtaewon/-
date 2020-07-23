
import React from 'react'
import { View, Text, StyleSheet} from "react-native";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import {Svg, Rect, Defs, Line, LinearGradient, Stop} from "react-native-svg";

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

var maxtemp = 0;

export default function MakeTable(list)
{
  
  const maxtemplist = list.data.map((x) => x.temp.max);
  var maxtemp = maxtemp > Math.max.apply(null,maxtemplist) ? maxtemp : Math.max.apply(null,maxtemplist) ;

    return(

        <View style={styles.Container} >
                {
                    list.data.map((x) =>
                <View style={styles.TableContainer} key={new Date(x.dt*1000)}>
                   <View style={styles.mb10}>
                    <Text style={styles.date}>{new Date(x.dt*1000).getMonth()+1}월 {new Date(x.dt*1000).getDate()}일</Text>
                    <MaterialCommunityIcons
                        size={40}
                        name={weatherOptions[x.weather[0].main].iconName}
                        color="white"
                    />
                  </View>
                    <View style={styles.Container} >
                      <View style={styles.box1}>
                        <Svg width="100" height="60" version="1.1">
                          <Defs>
                            <LinearGradient id="grad" x1="0" y1="1" x2="0" y2="0">
                              <Stop offset="0" stopColor="blue" stopOpacity="1" />
                              <Stop offset="1" stopColor="red" stopOpacity="1" />
                            </LinearGradient>
                          </Defs>
                          <Line x1="50" y1="0" x2="50" y2="100" stroke="white" strokeWidth="2" />
                          <Rect 
                            width="10" 
                            height={(x.temp.max - x.temp.min)*5}
                            x="45" 
                            y={maxtemp - x.temp.max+5}
                            fill="url(#grad)"
                          />
                        </Svg>
                      </View>

                      <View style={styles.box2}>
                        <Text style={styles.temp}>최고 온도: {x.temp.max}°</Text>
                        <Text style={styles.temp}>최저 온도: {x.temp.min}°</Text>
                        <Text style={styles.temp}>습도: {x.humidity}%</Text>
                        <Text style={styles.temp}>풍속: {x.wind_speed}m/s</Text>
                      </View>
                    </View>

                </View>
                    )
                }
        </View>
    );
}

const styles = StyleSheet.create({
  Container: {
    flex: 1,
    flexDirection: 'row',
  },
  TableContainer: {
    alignItems: "flex-start",
    flex: 1,
    width: '100%',
    height: '100%',
    alignItems: 'center',
    borderWidth: 0.5,
    borderColor: "#f2f2f2",
  },
  date: {
    fontSize: 15,
    color: "white"
  },
  temp: {
    fontSize: 8,
    color: "white"
  },
  wind: {
    fontSize: 8,
    color: "white"
  },
  box1: {
    marginLeft: -45
  },
  box2: {
    marginLeft: -40
  },
  mb10: {
    marginBottom: 10,
    alignItems: 'center',
  }
});