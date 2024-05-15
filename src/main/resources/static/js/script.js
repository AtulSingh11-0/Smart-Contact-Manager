/**
 * Selecting necessary elements from the DOM.
 * @type {HTMLHtmlElement} html - The HTML element.
 * @type {HTMLElement} themeButton - The button to toggle theme.
 * @type {HTMLElement} themeText - Text indicating the current theme.
 */
const html = document.querySelector('html');
const themeButton = document.querySelector('#theme_button');
const themeText = document.querySelector('#theme_text');

/**
 * Add event listener to the theme button.
 * @event click
 * @memberof themeButton
 * @param {Function} toggleTheme - The function to toggle between light and dark theme.
 */
themeButton.addEventListener('click', toggleTheme);

/**
 * Function to apply the theme based on localStorage.
 */
function applyTheme() {
  /**
   * Get the current theme from localStorage.
   * @type {string}
   */
  const theme = getTheme();
  if (theme === 'light') {
    html.classList.remove('dark');
    html.classList.add(theme);
    themeText.textContent = 'Dark';
  } else {
    html.classList.remove('light');
    html.classList.add(theme);
    themeText.textContent = 'Light';
  }
}

/**
 * Function to toggle between light and dark theme.
 */
function toggleTheme() {
  /**
   * Toggle theme.
   * @type {string}
   */
  const theme = getTheme() === 'light' ? 'dark' : 'light';
  setTheme(theme);
  applyTheme();
}

/**
 * Function to set the theme in localStorage.
 * @param {string} theme - The theme to be set.
 */
function setTheme(theme) {
  localStorage.setItem('theme', theme);
}

/**
 * Function to get the current theme from localStorage.
 * @returns {string} The current theme.
 */
function getTheme() {
  return localStorage.getItem('theme') || 'light';
}