import React from "react";
import {Text, View} from "react-native";

export default function MakeTempText(data){

  const axislist = data.axis.map((a) => [a.x,a.y]);
  const templist = data.temp.map((a) => a);

  return (

    axislist.map((a,index)=>
      <View 
        key={Math.random()} 
        style={{
        position: "absolute",
        left: a[0]-3,
        top: a[1]-17,
        height: 30,
        width: 40
        }} >
        <Text style={{
          fontSize: 10,
          color: "white",
          }}>
          {templist[index]}
        </Text>
      </View>
    )
  );
}