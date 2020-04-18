module.exports = {
  root: true,
  // parserOptions: {
  //   parser: 'babel-eslint',
  //   sourceType: 'module'
  // },
  parserOptions: {
    ecmaFeatures: {
      legacyDecorators: true
    }
  },
  parser: "babel-eslint",
  env: {
    browser: true,
    node: true,
    es6: true
  },
  extends: ["eslint:recommended", "plugin:react/recommended"],

  // add your custom rules here
  //it is base on https://github.com/vuejs/eslint-config-vue
  rules: {
    "react/prop-types": 0,
    "react/no-deprecated": 0,
    "no-prototype-builtins": 0,
    "react/no-direct-mutation-state": 0,
    "react/display-name": 0,
    "no-case-declarations": 0,
    "react/jsx-no-target-blank": 0,
    "react/no-string-refs": 0,
    "react/no-find-dom-node": 0,
    "no-debugger": 1,
    "no-unused-vars": 1,
    "no-undef": 1
  }
};
