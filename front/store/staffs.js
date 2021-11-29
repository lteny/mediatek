export const state = () => ({
  staffs: []
})

export const mutations = {
  setStaffs(state, staffs) {
    state.staffs = staffs
  }
}

export const actions = {
  async fetch({commit}) {
    const staffs = await this.$axios.$get('http://localhost:9000/staff')
    commit('setStaffs', staffs)
  }
}

export const getters = {
  staffs: s => s.staffs
}
