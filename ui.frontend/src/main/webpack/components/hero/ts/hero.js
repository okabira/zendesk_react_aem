import React from "react";
import { Relationframe, Heading, Base, LinkGroup, Text, Button } from '@zendesk/greenhouse';

function strip(html){
    let doc = new DOMParser().parseFromString(html, 'text/html');
    return doc.body.textContent || "";
 }

const Hero = (props) => {
    console.log("Inside Hero");
   return  <Base
                columnWeight="contentSide"
                contentSide={<Relationframe shape="square">
                    <img alt="flowers" src={props.image.src}/></Relationframe>}
                contentUnderText={<LinkGroup><Button>{props.button.text}</Button></LinkGroup>}
                hasReverseMobileColumns
                heading={<Heading variant={props.title.type}>{props.title.text}</Heading>}
                text={<Text>{strip(`${props.text.text}`)}</Text>}
            />
}
export default Hero;
