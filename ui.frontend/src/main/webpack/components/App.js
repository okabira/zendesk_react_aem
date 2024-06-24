import React from 'react';
import Mapper  from '../mapping.js';

const renderComponent = (props) => {
    let listOfComponenetData = props.cqItems.root[':items']["container"][":items"];
    for (const component in listOfComponenetData) {
        let componentName = listOfComponenetData[component][":type"];
        if(Mapper.hasOwnProperty(componentName)) {
            return Mapper[componentName];
        }
    }
}

const App = (props) => {
    return (
      <div>
        {renderComponent(props)}
      </div>
    );
  };
  
export default App;