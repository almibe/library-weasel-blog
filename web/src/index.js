import axios from 'axios'
import page from 'page'
import 'bulma/css/bulma.css'
import { withComponent } from 'skatejs';

const Component = withComponent();

class GreetingComponent extends Component {
  render() {
    return 'Hello, <slot></slot>!';
  }
}

window.customElements.define('x-hello', GreetingComponent);

var element = document.createElement('x-hello')
document.body.appendChild(element)
