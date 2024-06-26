import React from "react";
import ReactDOM from 'react-dom';
import { Hero, Relationframe, Button, Heading } from '@zendesk/greenhouse';
import Mapper  from '../../../mapping.js';

function strip(html){
    let doc = new DOMParser().parseFromString(html, 'text/html');
    return doc.body.textContent || "";
 }

const getComponentProperties = (components) => {
    const { [':type']: _, ...componentProperties } = components;
    return componentProperties;
}

const renderComponent = (props) => {
    console.log("Inside render component");
    
    let pageChildComponents = [];
    //let childComponents = props[":items"]?.[":items"] || props["actions"];
    let childComponents = props["actions"];
        for (let child in childComponents) {
            let childComponentName = childComponents[child][':type'];
            console.log("Child ComponentName new", childComponentName);
            let childComponentsProperties = getComponentProperties(childComponents[child]);
            if(Mapper.hasOwnProperty(childComponentName)) {
                pageChildComponents.push({"childComponentName": Mapper[childComponentName], "childComponentProps": childComponentsProperties });
            }
        }
    
   
    return pageChildComponents;
}

const Teaser = (props) => {
   return  <Hero
                bgColor="baby_yoda_light"
                contentSide={
                <Relationframe shape="circle-quarter">
                    <img alt="flowers" src={props.imagePath }/>
                </Relationframe>}
                contentUnderText={renderComponent(props).map((item => {
                    return <>
                    <item.childComponentName {...item.childComponentProps}/>
                    </>
                }))}
                hasReverseMobileColumns
                heading={<Heading override="h2" variant="h1">{props.title}</Heading>}
                supertitle={props.pretitle}
                text={strip(`${props.description}`)}
        />
}

export default Teaser;