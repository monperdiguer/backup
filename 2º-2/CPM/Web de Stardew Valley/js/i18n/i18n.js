'use strict'; 

// Esquelto defensivo ReqI18N1
function initializeI18n() { 
    const translatableElements = document.querySelectorAll('[data-i18n]'); 

    const languageSwitcher = document.querySelector('#language-switcher'); 

    if (translatableElements.length === 0 && !languageSwitcher) { 
    console.log('Esta página todavía no está preparada para i18n.'); 

    return; 
    }

    const initialLocale = getSavedLocale(); 
    applyTranslations(initialLocale); 
    updateDynamicContent(initialLocale); 
    initializeLanguageSwitcher(initialLocale); 
} 

initializeI18n(); 

'use strict'; 

// ReqI18N4
function applyTranslations(locale) { 
    const dict = window.translations?.[locale]; 
    if(!dict) return;

    // Traducir textos
    const textElements = document.querySelectorAll('[data-i18n]');
    for (let i = 0; i < textElements.length; i++) { 
        const key =  textElements[i].dataset.i18n;
 
        if (dict[key]) { 
            textElements[i].textContent = dict[key]; 
        } 
    } 

    // Traducir atributos ReqI18N5
    const altElements = document.querySelectorAll('[data-i18n-alt]'); 
    for (let i = 0; i < altElements.length; i++) {
            const key = altElements[i].dataset.i18nAlt; 
    
            if (dict[key]) { 
                altElements[i].setAttribute('alt', dict[key]); 
            } 
        } 

    // Traducir placeholders ReqI18N5
    const placeholderElements = document.querySelectorAll('[data-i18n-placeholder]');
    for (let i = 0; i < placeholderElements.length; i++) {
        const key = placeholderElements[i].dataset.i18nPlaceholder;

        if (dict[key]) {
            placeholderElements[i].setAttribute('placeholder', dict[key]);
        }
    }

    // Traducir title ReqI18N5
    const titleElements = document.querySelectorAll('[data-i18n-title]');
    for (let i = 0; i < titleElements.length; i++) {
        // dataset lee los guiones en formato camelCase (i18nTitle)
        const key = titleElements[i].dataset.i18nTitle; 
        if (dict[key]) {
            titleElements[i].setAttribute('title', dict[key]);
        }
    }
    
    document.documentElement.lang = locale; 
} 

// ReqI18N6
// Almacena en el localStorage del navegador la preferencia de locale del usuario
// Permite recuperar ese valor
function setLocale(locale) { 
    const selectedLocale = window.translations[locale] ? locale : 'es'; 
    localStorage.setItem('preferredLanguage', selectedLocale); 
   
    applyTranslations(selectedLocale); 
    updateDynamicContent(selectedLocale); 
    initializeLanguageSwitcher(selectedLocale); 
} 

// Funcion para restaurar el idioma del localStorage
function getSavedLocale() { 
    const savedLocale = localStorage.getItem('preferredLanguage'); 
    return translations[savedLocale] ? savedLocale : 'es'; 
} 

function initializeLanguageSwitcher(locale) { 
    const languageSwitcher = document.querySelector('#language-switcher'); 
    if (languageSwitcher) { 
        languageSwitcher.value = locale; 
    }  
} 

// Nos aseguramos de que setLocale sea global. 
window.setLocale = setLocale;
window.getSavedLocale = getSavedLocale;
window.initializeLanguageSwitcher = initializeLanguageSwitcher;

// Funcion para traducir fechas ReqI18N7
function formatDate(dateValue, locale) { 
    const resolvedLocale = locale === 'en' ? 'en-US' : 'es-ES'; 
    return new Intl.DateTimeFormat(resolvedLocale, { dateStyle: 'long', timeStyle: 'short' }).format(dateValue); 
}

// Funcion para traducir numeros ReqI18N7
function formatCurrency(amount, locale) { 
    const resolvedLocale = locale === 'en' ? 'en-US' : 'es-ES'; 
    const currency = locale === 'en' ? 'USD' : 'EUR'; 
 
    return new Intl.NumberFormat(resolvedLocale, { style: 'currency', currency: currency }).format(amount); 
} 

function updateDynamicContent(locale) { 
    const meetingDateBox = document.querySelector('#juego-fecha'); 
    const meetingFeeBox = document.querySelector('#juego-coste'); 
     const meetingSummary = document.querySelector('#resumen-dinamico'); 
 
    if (meetingDateBox) { 
        const rawDate = meetingDateBox.dataset.fecha; 
        const meetingDate = new Date(rawDate); 
        meetingDateBox.textContent = formatDate(meetingDate, locale); 
    } 
 
    if (meetingFeeBox) { 
        const rawFee = Number(meetingFeeBox.dataset.coste); 
        meetingFeeBox.textContent = formatCurrency(rawFee, locale); 
    }

    // Modificamos el contenido textual de un elemento de forma dinamica desde JS
    if (meetingSummary) { 
        meetingSummary.textContent = buildMeetingSummary(locale); 
    } 
}

// ReqI18N8
function buildMeetingSummary(locale) { 
    const meetingDateBox = document.querySelector('#juego-fecha'); 
    const meetingFeeBox = document.querySelector('#juego-coste');
 
    const formattedDate = meetingDateBox ? meetingDateBox.textContent : ''; 
    const formattedFee = meetingFeeBox ? meetingFeeBox.textContent : '';
 
    if (locale === 'en') { 
        return `The next update will be on ${formattedDate}.
        Buy now the game for only ${formattedFee}.`; 
    } 

    return `La próxima actualización será el ${formattedDate}. 
    Comprá el juego ya por solo ${formattedFee}.`; 
}
