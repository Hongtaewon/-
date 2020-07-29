import React from "react";
import { LineChart } from "react-native-chart-kit";
import {Dimensions, Text, View, StyleSheet} from "react-native";
import MakeTempText from "./onCreateTemp";

export default function MakeChart({data}){


  const timelist = data.map((x) => new Date(x.dt*1000).getHours()+"시");
  const templist = data.map((x) => x.temp);
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
    <View style={styles.mlm50}>
        <LineChart 
          data={{
            labels: timelist,
            datasets: [
              {
                data: templist
              }
            ]
          }}
          width={(Dimensions.get('window').width)*2.5} // from react-native
          height={(Dimensions.get('window').height)/3}
          yAxisLabel=""
          yAxisSuffix="°"
          yAxisInterval={2} // optional, defaults to 1
          scaleYEnabled
          withShadow={false}
          withHorizontalLabels={false}
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
        />
        <MakeTempText axis={PointData} temp={templist}/>
      </View>
  );
}

const styles = StyleSheet.create({
  mlm50: {
    marginLeft:-50
  }
})