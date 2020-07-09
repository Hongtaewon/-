import React from 'react';
import PropTypes from 'prop-types';

//mounting, updating, unmounting <= Component Life Cycle.
class App extends React.Component{
  constructor(props){
    super(props);
    console.log("hello");
  }
  state = {
    count: -999999999999999
  };

  add = () => {
    this.setState(current => ({count:current.count+1}));
  };
  minus = () => {
    this.setState(current => ({count:current.count-1}));
  };


  componentDidMount(){
    console.log("component rendered");
  }
  componentDidUpdate(){
    console.log("component did updated");
  }
  componentWillUnmount(){
    console.log("bye bye");
  }

  render(){
    console.log("I`m rendering");
    return (
    <div>
      <h1>The number is {this.state.count}</h1>
      <button onClick={this.add}>Add</button>
      <button onClick={this.minus}>Minus</button>
    </div>
    )
  }
}

export default App;
