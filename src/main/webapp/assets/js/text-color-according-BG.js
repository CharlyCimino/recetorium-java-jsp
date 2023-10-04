// Adaptado de https://stackoverflow.com/questions/3942878/how-to-decide-font-color-in-white-or-black-depending-on-background-color
const textColorAccordingBG = (rgbArray, lightColor = "#FFF", darkColor = "#000") => {
    const r = rgbArray[0]; 
    const g = rgbArray[1]; 
    const b = rgbArray[2]; 
    return (((r * 0.299) + (g * 0.587) + (b * 0.114)) > 186) ? darkColor : lightColor;
};
