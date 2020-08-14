/**
 * 嵌套页面IFrame模块
 */

import {baseUrl} from "./global";

/**
 * 嵌套页面URL地址
 * @param url
 */
export function getIFramePath(url) {
  console.log('getIFramePath: ' + url)
  console.log("getIFramePath: 嵌套页面URL----1")
  let iframeUrl = ''
  if (/^iframe:.*/.test(url)) {
    iframeUrl = url.replace('iframe:', '')
  } else if (/^http[s]?:\/\/.*/.test(url)) {
    iframeUrl = url.replace('http://', '')
    if (iframeUrl.indexOf(":") != -1) {
      iframeUrl = iframeUrl.substring(iframeUrl.lastIndexOf(":") + 1)
    }
  }
  console.log("getIFramePath: 嵌套页面URL----2")
  return iframeUrl
}

/**
 * 嵌套页面路径
 * @param url
 * @returns {string}
 */
export function getIFrameUrl(url) {
  let iframeUrl = ''
  if (/^iframe:.*/.test(url)) {
    iframeUrl = baseUrl + url.replace('iframe:', '')
  } else if (/^http[s]?:\/\/.*/.test(url)) {
    iframeUrl = url
  }
  return iframeUrl
}
