import { withComponent } from 'skatejs';
import withPreact from '@skatejs/renderer-preact';
import { h } from 'preact';

const Component = withComponent(withPreact());

class NotebookApp extends Component {
  render() {
    return (
      <div class="section">
        <div class="container">
          <h1>New Notebook</h1>
          <form>
            <div class="field">
              <label class="label">Title</label>
              <div class="control">
                <input class="input" type="text" name="title" />
              </div>
              <div class="field">
                <label class="label">Content</label>
                <div class="control">
                  <textarea class="textarea" name="content"></textarea>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    )
  }
}

function init() {
  window.customElements.define('notebook-app', NotebookApp);
}

export { init }
