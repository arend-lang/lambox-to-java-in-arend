#ifndef MATMUL_C
#define MATMUL_C
#include <gc_stack.h>
#include <prim_int63.h>
#include "matmul.h"
extern struct thread_info *make_tinfo(void);
extern value anon_118(struct thread_info *, value);
extern value anon_117(struct thread_info *, value);
extern value y_116(struct thread_info *, value, value);
extern value y_115(struct thread_info *, value, value);
extern value prim_wrapper_114(struct thread_info *, value, value);
extern value prim_wrapper_113(struct thread_info *, value, value);
extern value prim_wrapper_112(struct thread_info *, value, value);
extern value prim_wrapper_111(struct thread_info *, value, value);
extern value y_110(struct thread_info *, value, value);
extern value y_109(struct thread_info *, value, value);
extern value anon_uncurried_uncurried_uncurried_uncurried_108(struct thread_info *, value, value, value, value, value);
extern value anon_uncurried_107(struct thread_info *, value, value);
extern value anon_uncurried_106(struct thread_info *, value, value);
extern value anon_uncurried_uncurried_105(struct thread_info *, value, value, value);
extern value body(struct thread_info *);
value anon_118(struct thread_info *, value);
value anon_117(struct thread_info *, value);
value y_116(struct thread_info *, value, value);
value y_115(struct thread_info *, value, value);
value prim_wrapper_114(struct thread_info *, value, value);
value prim_wrapper_113(struct thread_info *, value, value);
value prim_wrapper_112(struct thread_info *, value, value);
value prim_wrapper_111(struct thread_info *, value, value);
value y_110(struct thread_info *, value, value);
value y_109(struct thread_info *, value, value);
value anon_uncurried_uncurried_uncurried_uncurried_108(struct thread_info *, value, value, value, value, value);
value anon_uncurried_107(struct thread_info *, value, value);
value anon_uncurried_106(struct thread_info *, value, value);
value anon_uncurried_uncurried_105(struct thread_info *, value, value, value);
value body(struct thread_info *);
unsigned long long const body_info_274[2] = { 5LL, 0LL, };

unsigned long long const anon_uncurried_uncurried_info_273[5] = { 0LL, 3LL,
  0LL, 1LL, 2LL, };

unsigned long long const anon_uncurried_info_272[4] = { 0LL, 2LL, 0LL, 1LL,
  };

unsigned long long const anon_uncurried_info_271[4] = { 0LL, 2LL, 0LL, 1LL,
  };

unsigned long long const anon_uncurried_uncurried_uncurried_uncurried_info_270[7] = {
  0LL, 5LL, 0LL, 1LL, 2LL, 3LL, 4LL, };

unsigned long long const y_info_269[4] = { 0LL, 2LL, 0LL, 1LL, };

unsigned long long const y_info_268[4] = { 0LL, 2LL, 0LL, 1LL, };

unsigned long long const prim_wrapper_info_267[4] = { 5LL, 2LL, 0LL, 1LL, };

unsigned long long const prim_wrapper_info_266[4] = { 0LL, 2LL, 0LL, 1LL, };

unsigned long long const prim_wrapper_info_265[4] = { 5LL, 2LL, 0LL, 1LL, };

unsigned long long const prim_wrapper_info_264[4] = { 0LL, 2LL, 0LL, 1LL, };

unsigned long long const y_info_263[4] = { 7LL, 2LL, 0LL, 1LL, };

unsigned long long const y_info_262[4] = { 0LL, 2LL, 0LL, 1LL, };

unsigned long long const anon_info_261[3] = { 0LL, 1LL, 0LL, };

unsigned long long const anon_info_260[3] = { 0LL, 1LL, 0LL, };

value anon_118(struct thread_info *$tinfo, value $anon_231)
{
  struct stack_frame frame;
  value root[1];
  register value $y_232;
  register value $anon_233;
  register value $anon_234;
  register value $y_236;
  register value $y_237;
  register value $prim_238;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (($anon_231 & 1) == 0) {
    switch (*((value *) $anon_231 + -1LL) & 255LL) {
      default:
        $anon_233 = *((value *) $anon_231 + 0LL);
        $anon_234 = *((value *) $anon_231 + 1LL);
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 0LL) = $anon_234;
        frame.next = root + 1LL;
        (*$tinfo).fp = &frame;
        $y_236 =
          ((value (*)(struct thread_info *, value)) anon_117)
          ($tinfo, $anon_233);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        $anon_234 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 0LL) = $y_236;
        frame.next = root + 1LL;
        (*$tinfo).fp = &frame;
        $y_237 =
          ((value (*)(struct thread_info *, value)) anon_118)
          ($tinfo, $anon_234);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        $y_236 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $prim_238 =
          ((value (*)(value, value)) prim_int63_add)
          ($y_236, $y_237);
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $prim_238;
        break;
      
    }
  } else {
    switch ($anon_231 >> 1LL) {
      default:
        $y_232 = 1LLU;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_232;
        break;
      
    }
  }
}

value anon_117(struct thread_info *$tinfo, value $anon_224)
{
  struct stack_frame frame;
  value root[1];
  register value $y_225;
  register value $anon_226;
  register value $anon_227;
  register value $y_228;
  register value $prim_229;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (($anon_224 & 1) == 0) {
    switch (*((value *) $anon_224 + -1LL) & 255LL) {
      default:
        $anon_226 = *((value *) $anon_224 + 0LL);
        $anon_227 = *((value *) $anon_224 + 1LL);
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 0LL) = $anon_226;
        frame.next = root + 1LL;
        (*$tinfo).fp = &frame;
        $y_228 =
          ((value (*)(struct thread_info *, value)) anon_117)
          ($tinfo, $anon_227);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        $anon_226 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $prim_229 =
          ((value (*)(value, value)) prim_int63_add)
          ($anon_226, $y_228);
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $prim_229;
        break;
      
    }
  } else {
    switch ($anon_224 >> 1LL) {
      default:
        $y_225 = 1LLU;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_225;
        break;
      
    }
  }
}

value y_116(struct thread_info *$tinfo, value $env_208, value $anon_209)
{
  struct stack_frame frame;
  value root[3];
  register value $anon_proj_211;
  register value $drandMat_proj_212;
  register value $y_213;
  register value $drandMat_proj_215;
  register value $y_216;
  register value $prim_wrapperbogus_env_218;
  register value $prim_wrapper_clo_219;
  register value $prim_wrapperbogus_env_220;
  register value $prim_wrapper_clo_221;
  register value $y_proj_222;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  $anon_proj_211 = *((value *) $env_208 + 2LL);
  $drandMat_proj_212 = *((value *) $env_208 + 0LL);
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  *(root + 1LL) = $anon_209;
  *(root + 0LL) = $env_208;
  frame.next = root + 2LL;
  (*$tinfo).fp = &frame;
  $y_213 =
    ((value (*)(struct thread_info *, value, value)) anon_uncurried_106)
    ($tinfo, $anon_proj_211, $drandMat_proj_212);
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $anon_209 = *(root + 1LL);
  $env_208 = *(root + 0LL);
  (*$tinfo).fp = frame.prev;
  $drandMat_proj_215 = *((value *) $env_208 + 0LL);
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  *(root + 1LL) = $y_213;
  *(root + 0LL) = $env_208;
  frame.next = root + 2LL;
  (*$tinfo).fp = &frame;
  $y_216 =
    ((value (*)(struct thread_info *, value, value)) anon_uncurried_107)
    ($tinfo, $anon_209, $drandMat_proj_215);
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  if (!(6LL <= $limit - $alloc)) {
    *(root + 2LL) = $y_216;
    frame.next = root + 3LL;
    (*$tinfo).nalloc = 6LL;
    garbage_collect($tinfo);
    $y_216 = *(root + 2LL);
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  $y_213 = *(root + 1LL);
  $env_208 = *(root + 0LL);
  (*$tinfo).fp = frame.prev;
  $prim_wrapperbogus_env_218 = 1LL;
  $prim_wrapper_clo_219 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $prim_wrapper_clo_219 + -1LL) = 2048LL;
  *((value *) $prim_wrapper_clo_219 + 0LL) = prim_wrapper_113;
  *((value *) $prim_wrapper_clo_219 + 1LL) = $prim_wrapperbogus_env_218;
  $prim_wrapperbogus_env_220 = 1LL;
  $prim_wrapper_clo_221 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $prim_wrapper_clo_221 + -1LL) = 2048LL;
  *((value *) $prim_wrapper_clo_221 + 0LL) = prim_wrapper_111;
  *((value *) $prim_wrapper_clo_221 + 1LL) = $prim_wrapperbogus_env_220;
  $y_proj_222 = *((value *) $env_208 + 1LL);
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  $result =
    ((value (*)(struct thread_info *, value, value, value, value, value)) 
      anon_uncurried_uncurried_uncurried_uncurried_108)
    ($tinfo, $y_216, $y_213, $prim_wrapper_clo_219, $prim_wrapper_clo_221,
     $y_proj_222);
  return $result;
}

value y_115(struct thread_info *$tinfo, value $env_199, value $anon_200)
{
  struct stack_frame frame;
  value root[2];
  register value $drandMat_proj_201;
  register value $y_proj_202;
  register value $env_203;
  register value $y_204;
  register value $y_proj_206;
  register value $y_clo_207;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (!(7LL <= $limit - $alloc)) {
    *(root + 1LL) = $anon_200;
    *(root + 0LL) = $env_199;
    frame.next = root + 2LL;
    (*$tinfo).fp = &frame;
    (*$tinfo).nalloc = 7LL;
    garbage_collect($tinfo);
    $anon_200 = *(root + 1LL);
    $env_199 = *(root + 0LL);
    (*$tinfo).fp = frame.prev;
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  $drandMat_proj_201 = *((value *) $env_199 + 0LL);
  $y_proj_202 = *((value *) $env_199 + 1LL);
  $env_203 = (value) ($alloc + 1LL);
  $alloc = $alloc + 4LL;
  *((value *) $env_203 + -1LL) = 3072LL;
  *((value *) $env_203 + 0LL) = $drandMat_proj_201;
  *((value *) $env_203 + 1LL) = $y_proj_202;
  *((value *) $env_203 + 2LL) = $anon_200;
  $y_204 = 1LLU;
  $y_proj_206 = *((value *) $env_199 + 2LL);
  $y_clo_207 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $y_clo_207 + -1LL) = 2048LL;
  *((value *) $y_clo_207 + 0LL) = y_116;
  *((value *) $y_clo_207 + 1LL) = $env_203;
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  $result =
    ((value (*)(struct thread_info *, value, value, value)) anon_uncurried_uncurried_105)
    ($tinfo, $y_204, $y_proj_206, $y_clo_207);
  return $result;
}

value prim_wrapper_114(struct thread_info *$tinfo, value $env_195, value $p_arg_196)
{
  struct stack_frame frame;
  value root[2];
  register value $p_arg_proj_197;
  register value $prim_198;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  $p_arg_proj_197 = *((value *) $env_195 + 0LL);
  $prim_198 =
    ((value (*)(value, value)) prim_int63_mul)
    ($p_arg_proj_197, $p_arg_196);
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $prim_198;
}

value prim_wrapper_113(struct thread_info *$tinfo, value $env_191, value $p_arg_192)
{
  struct stack_frame frame;
  value root[1];
  register value $env_193;
  register value $prim_wrapper_clo_194;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (!(5LL <= $limit - $alloc)) {
    *(root + 0LL) = $p_arg_192;
    frame.next = root + 1LL;
    (*$tinfo).fp = &frame;
    (*$tinfo).nalloc = 5LL;
    garbage_collect($tinfo);
    $p_arg_192 = *(root + 0LL);
    (*$tinfo).fp = frame.prev;
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  $env_193 = (value) ($alloc + 1LL);
  $alloc = $alloc + 2LL;
  *((value *) $env_193 + -1LL) = 1024LL;
  *((value *) $env_193 + 0LL) = $p_arg_192;
  $prim_wrapper_clo_194 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $prim_wrapper_clo_194 + -1LL) = 2048LL;
  *((value *) $prim_wrapper_clo_194 + 0LL) = prim_wrapper_114;
  *((value *) $prim_wrapper_clo_194 + 1LL) = $env_193;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $prim_wrapper_clo_194;
}

value prim_wrapper_112(struct thread_info *$tinfo, value $env_187, value $p_arg_188)
{
  struct stack_frame frame;
  value root[2];
  register value $p_arg_proj_189;
  register value $prim_190;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  $p_arg_proj_189 = *((value *) $env_187 + 0LL);
  $prim_190 =
    ((value (*)(value, value)) prim_int63_add)
    ($p_arg_proj_189, $p_arg_188);
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $prim_190;
}

value prim_wrapper_111(struct thread_info *$tinfo, value $env_183, value $p_arg_184)
{
  struct stack_frame frame;
  value root[1];
  register value $env_185;
  register value $prim_wrapper_clo_186;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (!(5LL <= $limit - $alloc)) {
    *(root + 0LL) = $p_arg_184;
    frame.next = root + 1LL;
    (*$tinfo).fp = &frame;
    (*$tinfo).nalloc = 5LL;
    garbage_collect($tinfo);
    $p_arg_184 = *(root + 0LL);
    (*$tinfo).fp = frame.prev;
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  $env_185 = (value) ($alloc + 1LL);
  $alloc = $alloc + 2LL;
  *((value *) $env_185 + -1LL) = 1024LL;
  *((value *) $env_185 + 0LL) = $p_arg_184;
  $prim_wrapper_clo_186 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $prim_wrapper_clo_186 + -1LL) = 2048LL;
  *((value *) $prim_wrapper_clo_186 + 0LL) = prim_wrapper_112;
  *((value *) $prim_wrapper_clo_186 + 1LL) = $env_185;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $prim_wrapper_clo_186;
}

value y_110(struct thread_info *$tinfo, value $env_180, value $anon_181)
{
  struct stack_frame frame;
  value root[1];
  register value $drandVec_proj_182;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  $drandVec_proj_182 = *((value *) $env_180 + 0LL);
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $drandVec_proj_182;
}

value y_109(struct thread_info *$tinfo, value $env_177, value $anon_178)
{
  struct stack_frame frame;
  value root[1];
  register value $drandNat_proj_179;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  $drandNat_proj_179 = *((value *) $env_177 + 0LL);
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $drandNat_proj_179;
}

value anon_uncurried_uncurried_uncurried_uncurried_108(struct thread_info *$tinfo, value $anon_156, value $anon_157, value $anon_158, value $anon_159, value $anon_160)
{
  struct stack_frame frame;
  value root[6];
  register value $anon_161;
  register value $anon_162;
  register value $anon_163;
  register value $anon_164;
  register value $anon_code_165;
  register value $anon_env_166;
  register value $y_167;
  register value $y_code_168;
  register value $y_env_169;
  register value $y_170;
  register value $anon_code_171;
  register value $anon_env_172;
  register value $y_173;
  register value $y_174;
  register value $y_code_175;
  register value $y_env_176;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (($anon_157 & 1) == 0) {
    switch (*((value *) $anon_157 + -1LL) & 255LL) {
      default:
        $anon_161 = *((value *) $anon_157 + 0LL);
        $anon_162 = *((value *) $anon_157 + 1LL);
        if (($anon_156 & 1) == 0) {
          switch (*((value *) $anon_156 + -1LL) & 255LL) {
            default:
              $anon_163 = *((value *) $anon_156 + 0LL);
              $anon_164 = *((value *) $anon_156 + 1LL);
              $anon_code_165 = *((value *) $anon_158 + 0LL);
              $anon_env_166 = *((value *) $anon_158 + 1LL);
              $args = (*$tinfo).args;
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              *(root + 5LL) = $anon_164;
              *(root + 4LL) = $anon_163;
              *(root + 3LL) = $anon_162;
              *(root + 2LL) = $anon_160;
              *(root + 1LL) = $anon_159;
              *(root + 0LL) = $anon_158;
              frame.next = root + 6LL;
              (*$tinfo).fp = &frame;
              $y_167 =
                ((value (*)(struct thread_info *, value, value)) $anon_code_165)
                ($tinfo, $anon_env_166, $anon_161);
              $alloc = (*$tinfo).alloc;
              $limit = (*$tinfo).limit;
              $anon_164 = *(root + 5LL);
              $anon_163 = *(root + 4LL);
              $anon_162 = *(root + 3LL);
              $anon_160 = *(root + 2LL);
              $anon_159 = *(root + 1LL);
              $anon_158 = *(root + 0LL);
              (*$tinfo).fp = frame.prev;
              $y_code_168 = *((value *) $y_167 + 0LL);
              $y_env_169 = *((value *) $y_167 + 1LL);
              $args = (*$tinfo).args;
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              *(root + 4LL) = $anon_164;
              *(root + 3LL) = $anon_162;
              *(root + 2LL) = $anon_160;
              *(root + 1LL) = $anon_159;
              *(root + 0LL) = $anon_158;
              frame.next = root + 5LL;
              (*$tinfo).fp = &frame;
              $y_170 =
                ((value (*)(struct thread_info *, value, value)) $y_code_168)
                ($tinfo, $y_env_169, $anon_163);
              $alloc = (*$tinfo).alloc;
              $limit = (*$tinfo).limit;
              $anon_164 = *(root + 4LL);
              $anon_162 = *(root + 3LL);
              $anon_160 = *(root + 2LL);
              $anon_159 = *(root + 1LL);
              $anon_158 = *(root + 0LL);
              (*$tinfo).fp = frame.prev;
              $anon_code_171 = *((value *) $anon_159 + 0LL);
              $anon_env_172 = *((value *) $anon_159 + 1LL);
              $args = (*$tinfo).args;
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              *(root + 4LL) = $anon_164;
              *(root + 3LL) = $anon_162;
              *(root + 2LL) = $anon_160;
              *(root + 1LL) = $anon_159;
              *(root + 0LL) = $anon_158;
              frame.next = root + 5LL;
              (*$tinfo).fp = &frame;
              $y_173 =
                ((value (*)(struct thread_info *, value, value)) $anon_code_171)
                ($tinfo, $anon_env_172, $y_170);
              $alloc = (*$tinfo).alloc;
              $limit = (*$tinfo).limit;
              $anon_164 = *(root + 4LL);
              $anon_162 = *(root + 3LL);
              $anon_160 = *(root + 2LL);
              $anon_159 = *(root + 1LL);
              $anon_158 = *(root + 0LL);
              (*$tinfo).fp = frame.prev;
              $args = (*$tinfo).args;
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              *(root + 0LL) = $y_173;
              frame.next = root + 1LL;
              (*$tinfo).fp = &frame;
              $y_174 =
                ((value (*)(struct thread_info *, value, value, value, value, value)) 
                  anon_uncurried_uncurried_uncurried_uncurried_108)
                ($tinfo, $anon_164, $anon_162, $anon_158, $anon_159,
                 $anon_160);
              $alloc = (*$tinfo).alloc;
              $limit = (*$tinfo).limit;
              $y_173 = *(root + 0LL);
              (*$tinfo).fp = frame.prev;
              $y_code_175 = *((value *) $y_173 + 0LL);
              $y_env_176 = *((value *) $y_173 + 1LL);
              $args = (*$tinfo).args;
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              $result =
                ((value (*)(struct thread_info *, value, value)) $y_code_175)
                ($tinfo, $y_env_176, $y_174);
              return $result;
              break;
            
          }
        } else {
          switch ($anon_156 >> 1LL) {
            default:
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              return $anon_160;
              break;
            
          }
        }
        break;
      
    }
  } else {
    switch ($anon_157 >> 1LL) {
      default:
        if (($anon_156 & 1) == 0) {
          switch (*((value *) $anon_156 + -1LL) & 255LL) {
            default:
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              return $anon_160;
              break;
            
          }
        } else {
          switch ($anon_156 >> 1LL) {
            default:
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              return $anon_160;
              break;
            
          }
        }
        break;
      
    }
  }
}

value anon_uncurried_107(struct thread_info *$tinfo, value $anon_146, value $anon_147)
{
  struct stack_frame frame;
  value root[2];
  register value $y_148;
  register value $anon_149;
  register value $anon_150;
  register value $y_152;
  register value $y_153;
  register value $y_154;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (($anon_147 & 1) == 0) {
    switch (*((value *) $anon_147 + -1LL) & 255LL) {
      default:
        $anon_149 = *((value *) $anon_147 + 0LL);
        $anon_150 = *((value *) $anon_147 + 1LL);
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 1LL) = $anon_150;
        *(root + 0LL) = $anon_146;
        frame.next = root + 2LL;
        (*$tinfo).fp = &frame;
        $y_152 =
          ((value (*)(struct thread_info *, value, value)) anon_uncurried_106)
          ($tinfo, $anon_146, $anon_149);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        $anon_150 = *(root + 1LL);
        $anon_146 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 0LL) = $y_152;
        frame.next = root + 1LL;
        (*$tinfo).fp = &frame;
        $y_153 =
          ((value (*)(struct thread_info *, value, value)) anon_uncurried_107)
          ($tinfo, $anon_146, $anon_150);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        if (!(3LL <= $limit - $alloc)) {
          *(root + 1LL) = $y_153;
          frame.next = root + 2LL;
          (*$tinfo).nalloc = 3LL;
          garbage_collect($tinfo);
          $y_153 = *(root + 1LL);
          $alloc = (*$tinfo).alloc;
          $limit = (*$tinfo).limit;
        }
        $y_152 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $y_154 = (value) ($alloc + 1LL);
        $alloc = $alloc + 3LL;
        *((value *) $y_154 + -1LL) = 2048LL;
        *((value *) $y_154 + 0LL) = $y_152;
        *((value *) $y_154 + 1LL) = $y_153;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_154;
        break;
      
    }
  } else {
    switch ($anon_147 >> 1LL) {
      default:
        $y_148 = 1LL;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_148;
        break;
      
    }
  }
}

value anon_uncurried_106(struct thread_info *$tinfo, value $anon_136, value $anon_137)
{
  struct stack_frame frame;
  value root[2];
  register value $y_138;
  register value $anon_139;
  register value $anon_140;
  register value $y_141;
  register value $prim_142;
  register value $y_143;
  register value $prim_144;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (($anon_137 & 1) == 0) {
    switch (*((value *) $anon_137 + -1LL) & 255LL) {
      default:
        $anon_139 = *((value *) $anon_137 + 0LL);
        $anon_140 = *((value *) $anon_137 + 1LL);
        $y_141 = 1LLU;
        $prim_142 =
          ((value (*)(value, value)) prim_int63_eqb)
          ($anon_136, $y_141);
        if (($prim_142 & 1) == 0) {
          switch (*((value *) $prim_142 + -1LL) & 255LL) {
            
          }
        } else {
          switch ($prim_142 >> 1LL) {
            case 0:
              $y_143 = 3LLU;
              $prim_144 =
                ((value (*)(value, value)) prim_int63_sub)
                ($anon_136, $y_143);
              $args = (*$tinfo).args;
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              $result =
                ((value (*)(struct thread_info *, value, value)) anon_uncurried_106)
                ($tinfo, $prim_144, $anon_140);
              return $result;
              break;
            default:
              (*$tinfo).alloc = $alloc;
              (*$tinfo).limit = $limit;
              return $anon_139;
              break;
            
          }
        }
        break;
      
    }
  } else {
    switch ($anon_137 >> 1LL) {
      default:
        $y_138 = 1LLU;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_138;
        break;
      
    }
  }
}

value anon_uncurried_uncurried_105(struct thread_info *$tinfo, value $anon_120, value $anon_121, value $anon_122)
{
  struct stack_frame frame;
  value root[3];
  register value $y_123;
  register value $prim_124;
  register value $anon_code_125;
  register value $anon_env_126;
  register value $y_127;
  register value $y_128;
  register value $prim_129;
  register value $y_130;
  register value $prim_131;
  register value $y_132;
  register value $y_133;
  register value $y_134;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  register _Bool $arg;
  register value $result;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  $y_123 = 1LLU;
  $prim_124 = ((value (*)(value, value)) prim_int63_eqb)($anon_121, $y_123);
  if (($prim_124 & 1) == 0) {
    switch (*((value *) $prim_124 + -1LL) & 255LL) {
      
    }
  } else {
    switch ($prim_124 >> 1LL) {
      case 0:
        $anon_code_125 = *((value *) $anon_122 + 0LL);
        $anon_env_126 = *((value *) $anon_122 + 1LL);
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 2LL) = $anon_122;
        *(root + 1LL) = $anon_121;
        *(root + 0LL) = $anon_120;
        frame.next = root + 3LL;
        (*$tinfo).fp = &frame;
        $y_127 =
          ((value (*)(struct thread_info *, value, value)) $anon_code_125)
          ($tinfo, $anon_env_126, $anon_120);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        $anon_122 = *(root + 2LL);
        $anon_121 = *(root + 1LL);
        $anon_120 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $y_128 = 3LLU;
        $prim_129 =
          ((value (*)(value, value)) prim_int63_sub)
          ($anon_121, $y_128);
        $y_130 = 3LLU;
        $prim_131 =
          ((value (*)(value, value)) prim_int63_add)
          ($anon_120, $y_130);
        $args = (*$tinfo).args;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        *(root + 0LL) = $y_127;
        frame.next = root + 1LL;
        (*$tinfo).fp = &frame;
        $y_132 =
          ((value (*)(struct thread_info *, value, value, value)) anon_uncurried_uncurried_105)
          ($tinfo, $prim_131, $prim_129, $anon_122);
        $alloc = (*$tinfo).alloc;
        $limit = (*$tinfo).limit;
        if (!(3LL <= $limit - $alloc)) {
          *(root + 1LL) = $y_132;
          frame.next = root + 2LL;
          (*$tinfo).nalloc = 3LL;
          garbage_collect($tinfo);
          $y_132 = *(root + 1LL);
          $alloc = (*$tinfo).alloc;
          $limit = (*$tinfo).limit;
        }
        $y_127 = *(root + 0LL);
        (*$tinfo).fp = frame.prev;
        $y_133 = (value) ($alloc + 1LL);
        $alloc = $alloc + 3LL;
        *((value *) $y_133 + -1LL) = 2048LL;
        *((value *) $y_133 + 0LL) = $y_127;
        *((value *) $y_133 + 1LL) = $y_132;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_133;
        break;
      default:
        $y_134 = 1LL;
        (*$tinfo).alloc = $alloc;
        (*$tinfo).limit = $limit;
        return $y_134;
        break;
      
    }
  }
}

value body(struct thread_info *$tinfo)
{
  struct stack_frame frame;
  value root[1];
  register value $drandNat_240;
  register value $y_241;
  register value $env_242;
  register value $y_243;
  register value $y_clo_244;
  register value $drandVec_245;
  register value $y_246;
  register value $env_247;
  register value $y_248;
  register value $y_clo_249;
  register value $drandMat_250;
  register value $y_251;
  register value $y_252;
  register value $y_253;
  register value $env_254;
  register value $y_255;
  register value $y_clo_256;
  register value $dres_257;
  register value $dsumRes_259;
  register value *$alloc;
  register value *$limit;
  register value *$args;
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  $args = (*$tinfo).args;
  frame.next = root;
  frame.root = root;
  frame.prev = (*$tinfo).fp;
  if (!(5LL <= $limit - $alloc)) {
    /*skip*/;
    (*$tinfo).nalloc = 5LL;
    garbage_collect($tinfo);
    /*skip*/;
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  $drandNat_240 = 3LLU;
  $y_241 = 601LLU;
  $env_242 = (value) ($alloc + 1LL);
  $alloc = $alloc + 2LL;
  *((value *) $env_242 + -1LL) = 1024LL;
  *((value *) $env_242 + 0LL) = $drandNat_240;
  $y_243 = 1LLU;
  $y_clo_244 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $y_clo_244 + -1LL) = 2048LL;
  *((value *) $y_clo_244 + 0LL) = y_109;
  *((value *) $y_clo_244 + 1LL) = $env_242;
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  /*skip*/;
  $drandVec_245 =
    ((value (*)(struct thread_info *, value, value, value)) anon_uncurried_uncurried_105)
    ($tinfo, $y_243, $y_241, $y_clo_244);
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  if (!(5LL <= $limit - $alloc)) {
    *(root + 0LL) = $drandVec_245;
    frame.next = root + 1LL;
    (*$tinfo).fp = &frame;
    (*$tinfo).nalloc = 5LL;
    garbage_collect($tinfo);
    $drandVec_245 = *(root + 0LL);
    (*$tinfo).fp = frame.prev;
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  /*skip*/;
  $y_246 = 601LLU;
  $env_247 = (value) ($alloc + 1LL);
  $alloc = $alloc + 2LL;
  *((value *) $env_247 + -1LL) = 1024LL;
  *((value *) $env_247 + 0LL) = $drandVec_245;
  $y_248 = 1LLU;
  $y_clo_249 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $y_clo_249 + -1LL) = 2048LL;
  *((value *) $y_clo_249 + 0LL) = y_110;
  *((value *) $y_clo_249 + 1LL) = $env_247;
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  /*skip*/;
  $drandMat_250 =
    ((value (*)(struct thread_info *, value, value, value)) anon_uncurried_uncurried_105)
    ($tinfo, $y_248, $y_246, $y_clo_249);
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  if (!(7LL <= $limit - $alloc)) {
    *(root + 0LL) = $drandMat_250;
    frame.next = root + 1LL;
    (*$tinfo).fp = &frame;
    (*$tinfo).nalloc = 7LL;
    garbage_collect($tinfo);
    $drandMat_250 = *(root + 0LL);
    (*$tinfo).fp = frame.prev;
    $alloc = (*$tinfo).alloc;
    $limit = (*$tinfo).limit;
  }
  /*skip*/;
  $y_251 = 1LLU;
  $y_252 = 601LLU;
  $y_253 = 601LLU;
  $env_254 = (value) ($alloc + 1LL);
  $alloc = $alloc + 4LL;
  *((value *) $env_254 + -1LL) = 3072LL;
  *((value *) $env_254 + 0LL) = $drandMat_250;
  *((value *) $env_254 + 1LL) = $y_251;
  *((value *) $env_254 + 2LL) = $y_253;
  $y_255 = 1LLU;
  $y_clo_256 = (value) ($alloc + 1LL);
  $alloc = $alloc + 3LL;
  *((value *) $y_clo_256 + -1LL) = 2048LL;
  *((value *) $y_clo_256 + 0LL) = y_115;
  *((value *) $y_clo_256 + 1LL) = $env_254;
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  /*skip*/;
  $dres_257 =
    ((value (*)(struct thread_info *, value, value, value)) anon_uncurried_uncurried_105)
    ($tinfo, $y_255, $y_252, $y_clo_256);
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  /*skip*/;
  $args = (*$tinfo).args;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  /*skip*/;
  $dsumRes_259 =
    ((value (*)(struct thread_info *, value)) anon_118)
    ($tinfo, $dres_257);
  $alloc = (*$tinfo).alloc;
  $limit = (*$tinfo).limit;
  /*skip*/;
  (*$tinfo).alloc = $alloc;
  (*$tinfo).limit = $limit;
  return $dsumRes_259;
}


#endif /* MATMUL_C */
