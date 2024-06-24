import { ModelManager, Constants } from '@adobe/aem-spa-page-model-manager';
import { ThemeProvider } from '@zendeskgarden/react-theming';
import {
    greenhouse,
    greenhouse2,
} from "@zendesk/greenhouse";

import App from '../components/App.js';
import React from "react";
import ReactDOM from 'react-dom';

const primaryThemes = {
    greenhouse: [greenhouse, greenhouse2],
};
 
const ver = 1;

ModelManager.initialize().then((pageModel) => {
    const rootNode = document.getElementById('react-title');
    ReactDOM.render(
        <ThemeProvider theme={primaryThemes.greenhouse[ver]}>
            <React.StrictMode>
                <App
                    cqChildren={pageModel[Constants.CHILDREN_PROP]}
                    cqItems={pageModel[Constants.ITEMS_PROP]}
                    cqItemsOrder={pageModel[Constants.ITEMS_ORDER_PROP]}
                    cqPath={pageModel[Constants.PATH_PROP]}
                />
            </React.StrictMode>
        </ThemeProvider>,
        rootNode
        
    );
});

// // Loading a specific portion of model
// ModelManager.getData("/content/site/page/jcr:").then((data) => console.log(data));



