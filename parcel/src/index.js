import { h, app } from 'hyperapp'
import axios from 'axios'
import page from 'page'
import 'bulma/css/bulma.css'

const state = {
  title: "New Notebook",
  sections: []
}

const actions = {
}

const view = (state, actions) => (
  <div id="app" oncreate={ () => mounted() }>
  </div>
)

app(state, actions, view, document.body)

function mounted() {

}
