import React, { Component } from 'react'

class Timer extends Component {
  state = {
    seconds: 0
  }

  tick = () => {
    this.setState(prevState => ({
      seconds: prevState.seconds + 1
    }))
  }

  componentDidMount() {
    this.interval = setInterval(
      this.tick, 1000
    )
  }

  render() {
    return (
      <div>
        Seconds: {this.state.seconds}
      </div>
    )
  }
}

export default Counter