// let jsHelloWorld = () => {
//     const jsString = "Hello World";
//     console.log(jsString);
// };
// export default jsHelloWorld();

// import { ThemeProvider } from '@zendeskgarden/react-theming';
// import {
//     greenhouse,
//     greenhouse2,
// } from "@zendesk/greenhouse";

import React from "react";
import ReactDOM from 'react-dom';
// import { Hero, ActionFooter, LinkGroup, Button } from '@zendesk/greenhouse';

// const primaryThemes = {
//     greenhouse: [greenhouse, greenhouse2],
// };
 
// const ver = 1;

const rootNode = document.getElementById('react-title');
ReactDOM.render(
    <React.StrictMode>
    <h1>Hello World Testing React</h1>
    </React.StrictMode>,
    rootNode
    
);
