import React from "react";
import { Platform, StyleSheet, Text, View } from "react-native";
import Plotly from 'react-native-plotly';



export default function MakeChart(list)
{
  const timelist = list.data.map((x) => new Date(x.dt *1000));
  const templist = list.data.map((x) => x.temp);

  const upData = {
    __id: 'hourly temp',
    x: timelist,
    y: templist,
    type: 'scatter'
  };

  const test = {
    data: [upData],
    layout: { title: 'Plotly.js running in React Native!' }
  };

  return (
    <Plotly
    data={test.data}
    onLoad={() => console.log('loaded')}
    debug
    enableFullPlotly
  />
  )
}

