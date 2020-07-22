import React from "react";
import { Alert } from "react-native";
import Loading from "./Loading";
import * as Location from "expo-location";
import axios from "axios";
import Weather from "./Weather";

const API_KEY = "";

export default class extends React.Component {
  state = {
    isLoading: true
  };

  getWeather = async (latitude, longitude) => {
    const {data} = await axios.get(
      `http://api.openweathermap.org/data/2.5/onecall?lat=${latitude}&lon=${longitude}&exclude=currently&APPID=${API_KEY}&units=metric`
    );

    this.setState({
      isLoading: false,
      data
    });
  };
  getLocation = async () => {
    try {
      await Location.requestPermissionsAsync();
      const {
        coords: { latitude, longitude }
      } = await Location.getCurrentPositionAsync();
      this.getWeather(latitude, longitude);
    } catch (error) {
      Alert.alert("Can't find you.", "So sad");
    }
  };
  componentDidMount() {
    this.getLocation();
  }
  render() {
    const { isLoading, data } = this.state;
    return isLoading ? (
      <Loading />
    ) : (
      <Weather data={data} />
    );
  }
}


