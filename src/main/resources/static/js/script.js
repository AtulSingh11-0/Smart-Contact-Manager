/**
 * This script is responsible for handling theme changes and navigation to the sign-up page.
 */

/**
 * Selecting necessary elements from the DOM.
 */
const html = document.querySelector('html');
const themeButton = document.querySelector('#theme_button');
const themeText = document.querySelector('#theme_text');
const signUpButton = document.querySelector('#sign_up_button');
const loginButton = document.querySelector('#login_button');

/**
 * Add event listener to the theme button.
 */
themeButton.addEventListener('click', toggleTheme);

/**
 * Function to apply the theme based on localStorage.
 */
function applyTheme() {
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
  const theme = getTheme() === 'light' ? 'dark' : 'light';
  setTheme(theme);
  applyTheme();
}

/**
 * Function to set the theme in localStorage.
 */
function setTheme(theme) {
  localStorage.setItem('theme', theme);
}

/**
 * Function to get the current theme from localStorage.
 */
function getTheme() {
  return localStorage.getItem('theme') || 'light';
}

/**
 * Add event listener to the sign-up button.
 */
signUpButton.addEventListener('click', () => {
  window.location.href = '/sign-up';
});

loginButton.addEventListener('click', () => {
  window.location.href = '/login';
});

// Apply theme only when the page loads
applyTheme();
