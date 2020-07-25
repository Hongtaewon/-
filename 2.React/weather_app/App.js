import React from "react";
import { Alert,ScrollView, RefreshControl } from "react-native";
import Loading from "./Loading";
import * as Location from "expo-location";
import axios from "axios";
import Weather from "./Weather";

const API_KEY = "e61db370dd85bd5ff3765d6d41f0bd1c";

export default class extends React.Component {
  state = {
    isLoading: true,
    refreshing: false,
  };

  getWeather = async (latitude, longitude) => {
    const {data} = await axios.get(
      `http://api.openweathermap.org/data/2.5/onecall?lat=${latitude}&lon=${longitude}&exclude=currently&APPID=${API_KEY}&units=metric&lang=kr`
    );

    this.setState({
      isLoading: false,
      refreshing:false,
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

  _onRefresh = () => {
    this.setState({
      isLoading: true,
      refreshing:true,
    });
    this.getLocation();
  }

  render() {
    const { isLoading, data, refreshing } = this.state;
    return (

      <ScrollView 
        contentContainerStyle={{flexGrow: 1}}
        refreshControl= {
          <RefreshControl
            refreshing={refreshing}
            onRefresh={this._onRefresh}
          />
        }
      >
        {isLoading ? (<Loading data={refreshing}/>) : (<Weather data={data} />)
        }
      </ScrollView>
    )
    
  }
}