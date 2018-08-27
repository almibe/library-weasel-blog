import { props, withComponent } from 'skatejs';
import withPreact from '@skatejs/renderer-preact';
import { h } from 'preact';

const Component = withComponent(withPreact());

class NotebookApp extends Component {
  static get props() {
    return {
      name: props.string
    }
  }
  render() {
    return <span>Hello, world!</span>;
  }
}

function init() {
  window.customElements.define('notebook-app', NotebookApp);
}

export { init }

//<app>
//  <div id="app">
//    <div class="navbar">
//      <div class="container">
//        <a role="button" id="view">View</a> |
//        <a role="button" id="edit">Edit</a> |
//        <a href="/">Home</a>
//      </div>
//    </div>
//  </div>
//
//  <script>
//    const state = {
//      title: "New Notebook",
//      sections: [],
//      inEditMode: false
//    }
//
//
//  </script>
//
//
//</app>
