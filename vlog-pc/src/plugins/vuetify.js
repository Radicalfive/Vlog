// import Vue from 'vue'
// import Vuetify from 'vuetify/lib/framework'

// Vue.use(Vuetify)

// export default new Vuetify({})

import Vue from "vue";
import Vuetify from "vuetify";
import "vuetify/dist/vuetify.min.css";
import colors from "vuetify/lib/util/colors";

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: colors.teal.lighten2,
        secondary: colors.teal.lighten3,
        accent: colors.teal.lighten4,
        anchor: colors.teal.lighten2,
      },
      dark: {
        primary: colors.cyan.darken3,
        secondary: colors.cyan.darken1,
        normal: colors.cyan.lighten3,
      },
    },
  },
});
