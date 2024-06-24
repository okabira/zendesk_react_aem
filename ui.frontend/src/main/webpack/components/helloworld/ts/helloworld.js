import React from "react";
import ReactDOM from 'react-dom';
import { Hero, Relationframe, Button, Heading } from '@zendesk/greenhouse';

// const primaryThemes = {
//     greenhouse: [greenhouse, greenhouse2],
// };
 
// const ver = 1;

const HelloWorld = () => {
   return  <Hero
            bgColor="baby_yoda_light"
            contentSide={
            <Relationframe shape="circle-quarter">
                <img alt="flowers" src="https://web-assets.zendesk.com/images/p-greenhouse/flowery.jpg"/>
            </Relationframe>}
            contentUnderText={<Button href="#">Button CTA</Button>}
            hasReverseMobileColumns
            heading={<Heading override="h2" variant="h1">Build smarter, reach farther</Heading>}
            supertitle="Zendesk for small business"
            text="Your small and mighty team works hard. 
            Give them the gift of efficiency with Zendesk. 
            It’s powerful yet easy-to-use, and it’s designed to help your team work better together."
        />
}

export default HelloWorld;