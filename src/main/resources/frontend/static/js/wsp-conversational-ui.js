/*! For license information please see wsp-conversational-ui.44cff51c655be43ede7f.bundle.js.LICENSE.txt */
"use strict";(self.webpackChunkwsp_assets=self.webpackChunkwsp_assets||[]).push([[7569],{35967:function(e,t,i){i.r(t),i.d(t,{default:function(){return A}});var n=i(58168),o=i(92901),a=i(9417),r=i(77387),d=i(55893);function s(e,t,i){void 0===i&&(i="all");var n,o=window.document,a=o.createElement("link");if(t)n=t;else{var r=(o.body||o.getElementsByTagName("head")[0]).childNodes;n=r[r.length-1]}var d=o.styleSheets;function s(e){for(var t=a.href,i=d.length;i--;)if(d[i].href===t)return e();setTimeout((function(){s(e)}))}function u(){a.addEventListener&&a.removeEventListener("load",u),a.media=i||"all"}return a.rel="stylesheet",a.href=e,a.media="only x",function e(t){if(o.body)return t();setTimeout((function(){e(t)}))}((function(){n.parentNode.insertBefore(a,t?n:n.nextSibling)})),a.addEventListener&&a.addEventListener("load",u),a.onloadcssdefined=s,s(u),a}var u=i(53880),l=i(25082),c="cui:initialized",h="cui:contextUpdate",f="cui:loadState",C="cui:store",v=!1,w=function(e){function t(){var t;return(t=e.call(this)||this).cuiLoaded=t.cuiLoaded.bind((0,a.A)(t)),t.loadAndOpenCui=t.loadAndOpenCui.bind((0,a.A)(t)),t.handleProactiveOpen=t.handleProactiveOpen.bind((0,a.A)(t)),t.loadCui=t.loadCui.bind((0,a.A)(t)),t.onCuiClosed=t.onCuiClosed.bind((0,a.A)(t)),t.onCuiInitialized=t.onCuiInitialized.bind((0,a.A)(t)),t.onCuiOpened=t.onCuiOpened.bind((0,a.A)(t)),t.onCuiUnreadCountUpdate=t.onCuiUnreadCountUpdate.bind((0,a.A)(t)),t.onTriggerClick=t.onTriggerClick.bind((0,a.A)(t)),t.additionalCuiConfig={},t.bindGlobalEvents(),t}(0,r.A)(t,e);var d=t.prototype;return d.bindGlobalEvents=function(){this.bindCuiOpeners(),document.addEventListener("visibilitychange",this.handleVisibilityChange.bind(this)),window.addEventListener(c,this.onCuiInitialized),window.addEventListener("cui:load",this.loadAndOpenCui),window.addEventListener(u.HG,this.onCuiOpened),window.addEventListener("cui:unreadCountUpdate",this.onCuiUnreadCountUpdate),window.addEventListener(u.W7,this.onCuiClosed),window.addEventListener(u.rR,this.onLoadCuiAndSendMessageEvent.bind(this))},d.bindCuiOpeners=function(){var e=this;(0,l.us)(document.querySelectorAll(".js_start_cui")).forEach((function(t){return t.addEventListener("click",e.onTriggerClick)}))},d.connectedCallback=function(){var e=this;this.$bubbleButton=this.querySelector(".js_cui_notifier_button"),this.$bubbleButton&&this.$bubbleButton.addEventListener("click",(function(t){t.preventDefault(),v?g(u.Uw):e.loadAndOpenCui()})),this.waitingForLogin()?this.loadAndOpenCui():b()&&this.loadCui(),m()||localStorage.removeItem(C),b()?this.showBubbleButton():(localStorage.removeItem(f),window.dispatchEvent(new CustomEvent(u.m3))),this.config.isStandalone&&this.loadCuiStandAloneFromUrl(),this.config.isFullScreen&&this.loadCui(),this.config.proactiveConfig&&window.innerWidth>900&&setTimeout(this.handleProactiveOpen,this.config.proactiveConfig.popupDelay)},d.loadCuiStandAloneFromUrl=function(){var e=this,t=this.getDataFromSearchParams(),i=t.orderReference,n=t.orderItemId,o=t.sellerId,a=t.offerId,r=t.message,d=t.startWith,s=!(!t.isConversationStarter||!r);this.setAdditionalConfigForStandAlone(i,n,o,a,r,d).then((function(){e.loadCuiWithPromise().then((function(){var e,t;(p(),r)&&(null===(e=window["@wsp/conversational-ui"])||void 0===e||null===(t=e.api)||void 0===t||t.sendMessageFromEvent(decodeURIComponent(r),{isConversationStarter:s}))})),e.addMetaTagsForApp()}))},d.setAdditionalConfigForStandAlone=function(e,t,i,o,a,r){var d=this;return new Promise((function(s){"DSA"===r?d.additionalCuiConfig=(0,n.A)({},d.additionalCuiConfig,{startNewConversation:!0,startWith:"DSA",initializeConversationType:"DSA",sellerId:i,offerId:o}):(e||t||a||i||o)&&(d.additionalCuiConfig=(0,n.A)({},d.additionalCuiConfig,{startNewConversation:!0,startWith:"Billie",orderReference:e,orderItemId:t,sellerId:i,offerId:o})),s()}))},d.getDataFromSearchParams=function(){var e=new URLSearchParams(location.search);return{orderReference:e.get("orderReference"),orderItemId:e.get("orderItemId"),sellerId:e.get("sellerId"),offerId:e.get("offerId"),message:e.get("message"),startWith:e.get("startWith"),isConversationStarter:e.get("isConversationStarter")}},d.addMetaTagsForApp=function(){var e=document.createElement("meta");e.id="viewport",e.name="viewport",e.content="width=device-width; user-scalable=no; initial-scale=1; viewport-fit: cover;",document.getElementsByTagName("head")[0].appendChild(e)},d.onCuiClosed=function(){I(!1),this.$bubbleButton&&this.hideBubbleButton()},d.handleVisibilityChange=function(){m()&&"hidden"!==document.visibilityState?(this.showBubbleButton(),this.loadCui()):this.hideBubbleButton()},d.onCuiOpened=function(){window.px("contactflow:open"),this.$bubbleButton&&this.showBubbleButton()},d.onCuiUnreadCountUpdate=function(e){var t=e.detail.unreadCount;this.$bubbleButton&&(t?this.$bubbleButton.setAttribute("data-count",t):this.$bubbleButton.removeAttribute("data-count"))},d.showBubbleButton=function(){this.$bubbleButton&&this.$bubbleButton.classList.remove("is-hidden")},d.hideBubbleButton=function(){this.$bubbleButton&&this.$bubbleButton.classList.add("is-hidden")},d.onCuiInitialized=function(){v=!0},d.onTriggerClick=function(e){var t=e.currentTarget;e.preventDefault();var i={};t.dataset.orderItemId&&(i.orderItemId=e.currentTarget.dataset.orderItemId),t.dataset.orderReference&&(i.orderReference=e.currentTarget.dataset.orderReference),t.dataset.sellerId&&(i.sellerId=e.currentTarget.dataset.sellerId),t.dataset.offerId&&(i.offerId=e.currentTarget.dataset.offerId),t.dataset.startWith&&(this.additionalCuiConfig={initializeConversationType:t.dataset.startWith},t.dataset.isNewConversation?g(h,(0,n.A)({},this.additionalCuiConfig,{startNewConversation:!0})):g(h,this.additionalCuiConfig)),this.additionalCuiConfig=(0,n.A)({},this.additionalCuiConfig,i),Object.keys(i).length>0&&(window.CUI_CONFIG=(0,n.A)({},window.CUI_CONFIG,i),g(h,i)),v?(p(),function(){if(window["@wsp/conversational-ui"])return window["@wsp/conversational-ui"].api.hasBillieConversation();return!1}()&&"ContactBot"===t.dataset.startWith&&window["@wsp/conversational-ui"].api.contactNow()):this.loadAndOpenCui()},d.onLoadCuiAndSendMessageEvent=function(e){var t=e&&e.detail,i=t.startWith,n=t.message,o=t.isPredefinedConversationStarter,a=t.orderReference,r=t.orderItemId,d=t.sellerId,s=t.offerId,l=!(!n||!n.length),c=!(!o||!n);i&&(this.additionalCuiConfig={initializeConversationType:i,orderReference:a,orderItemId:r,sellerId:d,offerId:s,hasPendingMessage:l},g(h,this.additionalCuiConfig)),this.loadCuiWithPromise().then((function(){p(),I(!0),n&&n.length&&window["@wsp/conversational-ui"].api.sendMessageFromEvent(n,{isConversationStarter:c}),setTimeout((function(){window.dispatchEvent(new CustomEvent(u.C7))}),500)}))},d.loadCui=function(){this.isLoaded?window.dispatchEvent(new CustomEvent(u.m3)):(this.isLoaded=!0,I(!0),v?this.cuiLoaded():this.importCui())},d.importCui=function(){var e=this;return new Promise((function(t){var n=e.getAttribute("data-css"),o=e.getAttribute("data-theme-css");s(n),o&&s(o),Promise.all([i.e(9522),i.e(617),i.e(2978)]).then(i.bind(i,42978)).then((function(){e.cuiLoaded(),t()}))}))},d.loadCuiWithPromise=function(){var e=this;return new Promise((function(t){e.isLoaded?t():(e.isLoaded=!0,I(!0),v?(e.cuiLoaded(),t()):e.importCui().then((function(){return t()})))}))},d.handleProactiveOpen=function(){(function(){if(window["@wsp/conversational-ui"])return window["@wsp/conversational-ui"].api.hasActiveConversation()})()||this.loadAndOpenCui()},d.loadAndOpenCui=function(){if(v){var e=this.token;window["@wsp/conversational-ui"]&&window["@wsp/conversational-ui"].api.updateUserToken(e),p()}else window.addEventListener(c,p),this.loadCui()},d.cuiLoaded=function(){if(!v){v=!0;var e=window.location.pathname+window.location.search,t=this.token,i=(0,n.A)({},this.config,{pageUrl:e,chatrToken:t,hasPendingMessage:!1},this.additionalCuiConfig);window["@wsp/conversational-ui"]&&window["@wsp/conversational-ui"].initialize(i),window.dispatchEvent(new CustomEvent(u.m3))}},d.waitingForLogin=function(){return"true"===localStorage.getItem("cui:waitingForLogin")&&this.config.userIsLoggedIn},(0,o.A)(t,[{key:"token",get:function(){return document.cookie.replace(/(?:(?:^|.*;\s*)chatrToken\s*\=\s*([^;]*).*$)|^.*$/,"$1").replace(/^"(.*)"$/,"$1")}},{key:"config",get:function(){return JSON.parse(document.querySelector("[data-js-payload]").innerHTML)}}]),t}((0,d.A)(HTMLElement));function g(e,t){window.dispatchEvent(new CustomEvent(e,t&&{detail:t}))}function p(){g("cui:open")}function b(){return"true"===localStorage.getItem(f)&&m()}function m(){var e=localStorage.getItem("cui:validUntil");return null!==e&&parseInt(e,10)>(new Date).getTime()}function I(e){e?localStorage.setItem(f,e):localStorage.removeItem(f)}w.is="wsp-conversational-ui";var A=w}}]);