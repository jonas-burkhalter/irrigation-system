import Vue from 'vue';
import VueI18n from 'vue-i18n';

// Internationalization (i18n)
import en from '@/assets/translation/en';

Vue.use(VueI18n);

const messages = {
    en
};

const dateTimeFormats : any = {
    'en': {
        short: {
          year: 'numeric',
          month: 'short',
          day: 'numeric'
        },
        time: {
            hour: 'numeric',
            minute: 'numeric'
        },
      long: {
        year: 'numeric',
        month: 'long',
        day: 'numeric',
        weekday: 'long',
        hour: 'numeric',
        minute: 'numeric'
      }
    }
}
  

// Vee-Validate
// import { localize } from 'vee-validate';
// import vee_de from 'vee-validate/dist/locale/de';
// localize('de', vee_de);

const DEFAULT_LANGUAGE = 'en';
const NAVIGATIOR_LANGUAGE_SHORT = navigator.language.slice(0, 2);
// Create VueI18n instance with options
export default new VueI18n({
    // Check navigator language exists in translations, otherwise en is set
    // locale: Object.keys(messages).some((l) => l === NAVIGATIOR_LANGUAGE_SHORT)
    //     ? NAVIGATIOR_LANGUAGE_SHORT
    //     : DEFAULT_LANGUAGE,
    dateTimeFormats,
    locale: DEFAULT_LANGUAGE,
    messages // set locale messages
});
