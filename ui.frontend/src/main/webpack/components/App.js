import React from 'react';
import Mapper  from '../mapping.js';


const getComponentProperties = (components) => {
    for (key in components) {
        if (!key.startsWith(':')) continue;
        console.log(key, components[key]);
    }
}
const renderComponent = (props) => {
    let pageComponents = [];
    let listOfComponenetData = props.cqItems.root[':items']["container"][":items"];
    for (const component in listOfComponenetData) {
        let componentName = listOfComponenetData[component][":type"];
        let componentProperties = getComponentProperties(listOfComponenetData[component]);
        console.log("Hello", listOfComponenetData[component]);
         
        if(Mapper.hasOwnProperty(componentName)) {
            pageComponents.push(Mapper[componentName]);
        }
    }

    return pageComponents;
}

const App = (props) => {
    return (
      <div>
        {renderComponent(props).map((Item => {
            return <Item />;
        }))}
      </div>
    );
  };
  
export default App;