import React from 'react'
import { View, Text, StyleSheet} from "react-native";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import {Svg, Rect, Defs, Line, LinearGradient, Stop} from "react-native-svg";

const weatherOptions = {
    Thunderstorm: {
      iconName: "weather-lightning",
    },
    Drizzle: {
      iconName: "weather-hail",
    },
    Rain: {
      iconName: "weather-rainy",
    },
    Snow: {
      iconName: "weather-snowy",
    },
    Atmosphere: {
      iconName: "weather-hail",
    },
    Clear: {
      iconName: "weather-sunny",
    },
    Clouds: {
      iconName: "weather-cloudy",
    },
    Mist: {
      iconName: "weather-hail",
    },
    Dust: {
      iconName: "weather-hail",
    },
    Haze: {
      iconName: "weather-hail",
    }
  };


export default function MakeCandle(list)
{
  const maxtemplist = list.data.map((x) => x.temp.max);
  const mintemplist = list.data.map((x) => x.temp.min);
  var maxtemp = maxtemp > Math.max.apply(null,maxtemplist) ? maxtemp : Math.max.apply(null,maxtemplist);
  var multiple = 5;
  for(var i=0;i<maxtemplist.length;i++)
  {
    if(maxtemplist[i] - mintemplist[i] > 10) {
      multiple = 4;
      break;
    }
  }

    return(

        <View style={styles.Container} >
                {
                    list.data.map((x) =>
                <View style={styles.TableContainer} key={new Date(x.dt*1000)}>
                   <View style={styles.mb10}>
                    <Text style={styles.date}>
                      {new Date(x.dt*1000).getMonth()+1}/{new Date(x.dt*1000).getDate()}
                    </Text>
                    <MaterialCommunityIcons
                        size={40}
                        name={weatherOptions[x.weather[0].main].iconName}
                        color="white"
                    />
                  </View>
                    <View style={styles.InnerContainer} >
                      <View style={styles.box1}>
                        <Svg width="100" height="60" version="1.1">
                          <Defs>
                            <LinearGradient id="grad" x1="0" y1="1" x2="0" y2="0">
                              <Stop offset="0" stopColor="#3538D6" stopOpacity="1" />
                              <Stop offset="1" stopColor="#FF2A2A" stopOpacity="1" />
                            </LinearGradient>
                          </Defs>
                          <Line x1="50" y1="0" x2="50" y2="100" stroke="#FFFFFF" strokeWidth="2" />
                          <Rect 
                            width="10" 
                            height={(x.temp.max - x.temp.min)*multiple}
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
  InnerContainer: {
    flex: 1,
    flexDirection: 'row',
  },
  TableContainer: {
    alignItems: "flex-start",
    flex: 1,
    width: 110,
    height: '100%',
    alignItems: 'center',
    borderWidth: 0.3,
    borderColor: "#f2f2f2",
  },
  date: {
    fontSize: 15,
    color: "white",
    fontWeight: "600"
  },
  temp: {
    fontSize: 10,
    color: "white",
    fontWeight:"500"
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