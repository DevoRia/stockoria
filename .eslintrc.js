module.exports = {
  parser: '@typescript-eslint/parser',
  ignorePatterns: 'dist',
  parserOptions: {
    project: 'tsconfig.json',
    tsconfigRootDir : __dirname,
    sourceType: 'module',
  },
  plugins: ['@typescript-eslint'],
  extends: [
    'airbnb',
    'airbnb-typescript'
  ],
  rules: {
    "no-promise-executor-return": "off",
    "import/prefer-default-export": "off",
    "@typescript-eslint/no-unused-vars": "off",
    "@typescript-eslint/no-useless-constructor": "off",
    "class-methods-use-this": "off",
    "@typescript-eslint/no-shadow": "off"
  }
};
