import React, { Component } from 'react';
import './Move.js';
import './App.css';

let Move = require("./Move.js").default;

class App extends Component {
  moves=[];

  constructor(props){
    super(props);

    this.state={
      moves:[]
    }
  }

  componentDidMount(){
    fetch("http://localhost:8080/api/questions")
    .then(data=>data.json())
    .then(data=>{
      console.log(data);

      
      for(let i=0; i<data.moves.length; i++){
        this.moves.push(
          (
            <Move 
              key={i} 
              text={data.moves[i].move.name}
            />
          )
        )
      }

      this.setState({
          moves:this.moves
      })
      console.log(this.moves);
    })
    .catch(err=>console.log(err));
  }
  
  render() {
    return (
      <div className="App">
        {this.state.moves}
      </div>
    );
  }
}

export default App;
