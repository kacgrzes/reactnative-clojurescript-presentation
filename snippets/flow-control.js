if (lang === 'de') {
  return 'german';
}

if (lang === 'de') {
  return 'german';
} else {
  return 'english';
}

function whichLang(lang) {
  if (lang === 'de') {
    return 'german';
  } else if (lang === 'es') {
    return 'spanish';
  } else {
    return 'english';
  }
}

function whichLang(lang) {
  switch (lang) {
    case 'de':
      return 'german';
    case 'es':
      return 'spanish';
    default:
      return 'english';
  }
}