import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  moves = [];
  constructor(props){
    super(props)
    this.state = {
      moves:[]
    }
  }
  componentDidMount(){
    fetch("https://pokeapi.co/api/v2/pokemon/2/")
    .then(data => data.json())
    .then(data => {
      for(let i=0; i < data.moves.length; i ++){
        this.moves.push(
          (
            <h1 key={i}> { data.moves[i].move.name} </h1>
          )
        )
      }
      this.setState({
        moves:this.moves
      })
    })
    .catch(err => console.log(err))
  }
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        { this.state.moves }
      </div>
    );
  }
}

export default App;
