import request from '@/utils/request'

// 查询计算机列表
export function listComputer(query) {
  return request({
    url: '/it/computer/list',
    method: 'get',
    params: query
  })
}

// 查询计算机详细
export function getComputer(uid) {
  return request({
    url: '/it/computer/' + uid,
    method: 'get'
  })
}

// 新增计算机
export function addComputer(data) {
  return request({
    url: '/it/computer',
    method: 'post',
    data: data
  })
}

// 修改计算机
export function updateComputer(data) {
  return request({
    url: '/it/computer',
    method: 'put',
    data: data
  })
}

// 删除计算机
export function delComputer(uid) {
  return request({
    url: '/it/computer/' + uid,
    method: 'delete'
  })
}
