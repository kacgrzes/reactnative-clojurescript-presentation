import React, { Component } from 'react'

class Counter extends Component {
  state = { clickCount: 0 }

  increment = () => {
    this.setState(prevState => {
      clickCount: prevState.clickCount + 1
    })
  }

  render() {
    return (
      <div>
        The state has a value: {this.state.clickCount}
        <input
          type="button"
          value="Click me!"
          onClick={this.increment}
        />
      </div>
    )
  }
}

export default Counter
