import React from "react";
import { LineChart } from "react-native-chart-kit";
import {Dimensions, Text, View, StyleSheet} from "react-native";
import MakeTempText from "./onCreateTemp";

export default function MakeChart({data}){


  const timelist = data.map((x) => new Date(x.dt*1000).getHours());
  const templist = data.map((x) => x.temp);
  var current = new Date().getDate();
  var time = timelist.reduce(function(a,b,c){
    if(c%3==0) {
        a.push(b+"시");
    }
    return a;
  }, []).slice(0,8);
  var temp = templist.reduce(function(a,b,c){
    if(c%3==0) {
      a.push(b);
    }
    return a;
  }, []).slice(0,8);

  var PointData = [];
  return (
    <View>
        <LineChart 
          data={{
            labels: time,
            datasets: [
              {
                data: temp
              }
            ]
          }}
          width={(Dimensions.get('window').width)} // from react-native
          height={(Dimensions.get('window').height)/3}
          yAxisLabel=""
          yAxisSuffix="°"
          yAxisInterval={2} // optional, defaults to 1
          chartConfig={{
            backgroundGradientFromOpacity: 0,
            backgroundGradientToOpacity: 0,
            decimalPlaces: 2, // optional, defaults to 2dp
            color: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
            labelColor: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
            propsForDots: {
              r: "5",
              strokeWidth: "2",
              stroke: "#22a726"
            }
          }}
          renderDotContent={(x)=>{
            PointData.push(x);
          }}
          bezier
        />
        <MakeTempText axis={PointData} temp={temp}/>
      </View>
  );
}

